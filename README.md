# poi-spring-boot-starter

> 很多人都困惑POI那么多Jar到底应该导入哪一个。
实际上很多时候我们只利用POI来操作Excel。甚至只用xls这一种格式。
那么就没有必要全部都导入了。具体应该使用哪个JAR包请参考以下内容:

#### Component Map

> The Apache POI distribution consists of support for many document file formats. This support is provided in several Jar files. Not all of the Jars are needed for every format. The following tables show the relationships between POI components, Maven repository tags, and the project's Jar files.

| Component  | Application type  | Maven artifactId  | Notes  |
| :------------ | :------------ | :------------ | :------------ |
| POIFS  | OLE2 Filesystem  |  poi |  Required to work with OLE2 / POIFS based files |
| HPSF  |  OLE2 Property Sets | poi  |   |
| HSSF  | Excel XLS  | poi  | For HSSF only, if common SS is needed see below  |
| HSLF  | PowerPoint PPT  | poi-scratchpad  |   |
| HWPF  | Word DOC  |  poi-scratchpad |   |
| HDGF  | Visio VSD  | poi-scratchpad  |   |
| HPBF  | Publisher PUB  |  poi-scratchpad |   |
| HSMF  | Outlook MSG  | poi-scratchpad  |   |
| OpenXML4J  |  OOXML | poi-ooxml plus one of poi-ooxml-schemas, ooxml-schemas  |  Only one schemas jar is needed, see below for differences |
| XSSF  |  XLSX  | poi-ooxml  |   |
| XSLF  | PowerPoint PPTX  |  poi-ooxml |   |
| XWPF  | Word DOCX  |  poi-ooxml |   |
| Common SS  | Excel XLS and XLSX  |  poi-ooxml | WorkbookFactory and friends all require poi-ooxml, not just core poi  |

>当我们只要使用xls格式时、只要导入poi-version-yyyymmdd.jar就可以了。
当我们还要使用xlsx格式、还要导入poi-ooxml-version-yyyymmdd.jar。
至于poi-ooxml-schemas-version-yyyymmdd.jar这个jar基本不太会用到的。

>当我们需要操作word、ppt、viso、outlook等时需要用到poi-scratchpad-version-yyyymmdd.jar。
以上是poi的各个版本的内容，更多 java POI 多版本 HSSF XSSF java 的内容，请您使用右上方搜索功能获取相关信息。