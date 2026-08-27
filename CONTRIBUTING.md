# Contributing to Aristois Community Edition

## How to Contribute

### Mapping Contributions (Highest Priority)

The obfuscated JAR contains thousands of renamed classes, fields, and methods. We need the community to help identify them.

**Format (Tiny v2):**
```
c obfuscated/ClassName net/aristois/RealName
\tf field_a fieldValue I
\tm method_a (Ljava/lang/String;)V methodName
```

Add entries to `mappings/aristois-mappings.tiny` and submit a PR.

### Code Contributions

1. Fork the repo
2. Create a feature branch (`git checkout -b feature/your-thing`)
3. Make your changes
4. Ensure it builds (`./gradlew build`)
5. Submit a PR

### Code Style

- Follow the original codebase conventions (inferred from decompiled output)
- No tabs — 4 spaces
- No trailing whitespace
- Use descriptive variable names in NEW code (mapped code retains original naming until remapped)

### Paywall Stripping

If you find a license check that survived the pipeline, open an issue with the class name and line number.

## What NOT to Do

- Don't bundle the original JAR in commits
- Don't re-add paywalls or API key gates
- Don't claim affiliation with the original Aristois team

## Recognition

All contributors will be listed in the README. Mapping contributors especially — this project lives or dies on class recognition.