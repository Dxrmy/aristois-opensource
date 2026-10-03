package me.deftware.aristois.marketplace;

import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.List;
import me.deftware.aristois.recovered.C0139;
import me.deftware.aristois.recovered.C0140;
import me.deftware.client.framework.FrameworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Download {
   private static final Logger logger = LogManager.getLogger("Download");
   @SerializedName("url")
   private String url;
   @SerializedName("loader")
   private String loader = "Fabric";
   @SerializedName("redirect")
   private Download.Redirection redirection;
   @SerializedName("path")
   private Download.FilePath path;
   @SerializedName("sha1")
   private String sha1;
   @SerializedName("version")
   private String version;
   @SerializedName("regenerate")
   public boolean regenerate = true;

   public Download() {
   }

   public boolean isCompatible() {
      return FrameworkConstants.MAPPING_LOADER.name().equalsIgnoreCase(this.loader);
   }

   public void run() throws Exception {
      C0139 request = new C0139(this.url);
      if (this.redirection != null) {
         String contents = request.m_0017133f().m_e07cee76();

         for (Download.Instruction instruction : this.redirection.inst) {
            logger.debug("Executing instruction {}", new Object[]{instruction.getType()});
            if (!instruction.getType().equalsIgnoreCase("split")) {
               throw new RuntimeException("Unknown inst type " + instruction.getType());
            }

            contents = contents.split(instruction.getKeyword())[instruction.getIndex()];
         }

         request = new C0139(this.redirection.getUrl() + contents);
      }

      File file = this.path.toFile();
      File parent = file.getParentFile();
      if (!parent.exists() && !parent.mkdirs()) {
         throw new Exception("Unable to create download directory");
      } else {
         C0140 response = request.m_7978999d(this.path.toFile());
         if (!response.m_9362a920()) {
            logger.error(response.m_e991ec61());
            throw new Exception(String.format("%s returned non OK status code %s", request.m_dde8dbcb().getHost(), response.m_36ffc578()));
         }
      }
   }

   public String getUrl() {
      return this.url;
   }

   public String getLoader() {
      return this.loader;
   }

   public Download.Redirection getRedirection() {
      return this.redirection;
   }

   public Download.FilePath getPath() {
      return this.path;
   }

   public String getSha1() {
      return this.sha1;
   }

   public String getVersion() {
      return this.version;
   }

   public boolean isRegenerate() {
      return this.regenerate;
   }

   public static class FilePath {
      @SerializedName("type")
      private String type;
      @SerializedName("name")
      private String name;

      public FilePath() {
      }

      public File toFile() {
         return FilePaths.valueOf(this.type).resolve(MarketplaceMod.format(this.name));
      }

      public String getType() {
         return this.type;
      }

      public String getName() {
         return this.name;
      }
   }

   public static class Instruction {
      @SerializedName("type")
      private String type;
      @SerializedName("keyword")
      private String keyword;
      @SerializedName("index")
      private int index;

      public Instruction() {
      }

      public String getType() {
         return this.type;
      }

      public String getKeyword() {
         return this.keyword;
      }

      public int getIndex() {
         return this.index;
      }
   }

   public static class Redirection {
      @SerializedName("url")
      private String url;
      @SerializedName("inst")
      private List<Download.Instruction> inst;

      public Redirection() {
      }

      public String getUrl() {
         return this.url;
      }

      public List<Download.Instruction> getInst() {
         return this.inst;
      }
   }
}
