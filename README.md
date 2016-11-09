# pojo2xml
pojo与xml之间的相互转换
编译环境jdk1.8 +ant1.9.7+jibx1.2.6,注意使用bcel-6.0.jar替换jibx1.2.6中的bcel.jar，并命名为bcel.jar,原因在于jibx1.2.6与jdk1.8版本并不兼容，若是jdk1.7版本，则可以不用替换
1编写好相关的pojo类
2 在cmd命令终端下切换到相对应的java工程目录文件路径下，运行以下指令生成bingding.xml和相对应的schema文件(jibx.xsd)
java –cp E:\IdeaProjects\jibx\lib\jibx-tools.jar; E:\IdeaProjects\pojo2xml\out\production\pojo2xml org.jibx.binding.generator.BindGen –s src com.keydak.jibx.Order
3 通过binding.xml和jibx.xsd生成所需要的绑定文件类
java –cp E:\IdeaProjects\jibx\lib\jibx-bind.jar; E:\IdeaProjects\pojo2xml\out\production\pojo2xml org.jibx.binding.Complile –v binding.xml

4 可以尝试运行测试类TestOrder和Test类实现xml与pojo的互换


