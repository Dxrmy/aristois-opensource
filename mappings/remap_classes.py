import os, json, sys

# Portable: resolve paths relative to the repository root (parent of this file).
proj_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
mapping_file = os.path.join(proj_dir, 'mappings', 'class_to_mojmap.json')

with open(mapping_file, 'r') as f:
    mappings = json.load(f)

sorted_mappings = sorted(mappings.items(), key=lambda x: -len(x[0]))

src_dir = os.path.join(proj_dir, 'src', 'main', 'java')
files_modified = 0
total_replacements = 0

for root, dirs, files in os.walk(src_dir):
    for fname in files:
        if not fname.endswith('.java'):
            continue
        path = os.path.join(root, fname)
        with open(path, 'r', encoding='utf-8', errors='replace') as f:
            content = f.read()
        
        modified = content
        for intermediary, named in sorted_mappings:
            modified = modified.replace(intermediary, named)
        
        if modified != content:
            files_modified += 1
            total_replacements += 1
            with open(path, 'w', encoding='utf-8') as f:
                f.write(modified)

print('Modified %d files' % files_modified)