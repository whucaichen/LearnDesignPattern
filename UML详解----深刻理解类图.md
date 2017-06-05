<h1>
        <span class="link_title"><a href="http://blog.csdn.net/lxqluo/article/details/7012870">
        UML详解----深刻理解类图
        </a></span>
    </h1>

<div id="article_content" >

<p>[转载自<a href="http://z-xiaofei168.iteye.com/blog/1038269">http://z-xiaofei168.iteye.com/blog/1038269</a>]</p>
<p>&nbsp;</p>
<p>类图是面向对象系统建模中<strong>最常用</strong>的图. 是定义其他图的基础.</p>
<p>类图主要是用来<strong>显示系统中的类, 接口以及它们之间的关系</strong>.</p>
<p>类图包含的主要元素有类, 接口和关系. 其中关系有<strong>泛化关系</strong>,<strong>关联关系</strong>,<strong>依赖关系</strong>和<strong>实现关系</strong>. 在类图中也可以包含注释和约束.</p>
<p>&nbsp;</p>
<p><strong>1、 类的表示法</strong></p>
<p><strong>&nbsp;</strong></p>
<p>类是类图的主要组件, 由 3 部分组成: <strong>类名, 属性和方法</strong>. 在 UML 中, 类用矩形来表示, 顶端部分存放类的名称, 中间部分存放类的属性, 属性的类型及&#20540;, 底部部分存放类的方法, 方法的参数和返回类型.</p>
<p>&nbsp;</p>
<p>在 UML 中可以根据实际情况有选择的隐藏属性部分或方法部分或两者都隐藏</p>
<p>&nbsp;</p>
<p>在 UML 中,<strong>公有类型有 &#43; 表示, 私有类型用 – 表示, 保护类型用 # 表示</strong>. UML 的工具开发商可以使用自己定义的符号表示不同的可见性</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><img height="107" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89666/179acbaa-fc91-33a8-a619-b9e6f2453a9b.png" width="166">&nbsp;</p>
<p><strong>2、接口的表示法</strong></p>
<p>&nbsp;</p>
<p>接口中包含方法, 但不包含属性. 在 UML 中接口用一个带有名称的圆圈表示, 并且通过一条实线与它的模型元素相连.</p>
<p><img height="71" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89668/fec3ad78-20b0-3caf-af98-31ea1ab8e011.png" width="330">&nbsp;</p>
<p>&nbsp;</p>
<p>有时候接口也使用普通类符号表示:</p>
<p>&nbsp;</p>
<p><img height="90" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89670/baf1e29d-881c-36d5-9f7d-91ffbd5f06c9.png" width="295">&nbsp;</p>
<p>下面介绍一下类之间的关系</p>
<p>&nbsp;</p>
<p><strong>&lt;1&gt;.泛化关系</strong></p>
<p>在 UML 中, <strong>泛化关系</strong>用来表示类与类, 接口与接口之间的<strong>继承关系</strong>. 泛化关系有时也称为”is a kind of”关系</p>
<p>&nbsp;</p>
<p>在 UML 中<strong>泛化关系用一条实线空心箭头由子类指向父类</strong></p>
<p>&nbsp;</p>
<p><img height="232" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89672/e4e80422-66ba-33bc-b979-09878c1709b8.png" width="230">&nbsp;</p>
<p><strong>&lt;2&gt;.实现关系</strong></p>
<p>在 UML 中, 实现关系用来<strong>表示类与接口</strong>之间的实现关系. </p>
<p>在 UML 中实现关系用<strong>一条虚线空心箭头由子类指向父类</strong></p>
<p>&nbsp;</p>
<p><img height="214" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89674/4c24eb3f-adf8-351f-8cb0-4d6840d0d209.png" width="307">&nbsp;</p>
<p><strong>&lt;3&gt;.依赖关系</strong></p>
<p>对于两个相对独立的系统，当一个系统负责构造另一个系统的实例，或者依赖另一个系统的服务时，这两个系统之间体现为<strong>依赖关系</strong>. 例如生产零件的机器和零件，机器负责构造零件对象; 充电电池和充电器，充电电池通过充电器来充电;自行车Bicycle和打气筒Pump，自行车通过打气筒来充气</p>
<p>&nbsp;<img height="145" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89676/fc252079-1959-32e9-a109-265b9062837b.png" width="292"></p>
<p>在 UML 中依赖关系用<strong>一条虚线箭头由依赖系统指向被依赖系统</strong></p>
<p><strong>案例：</strong></p>
<p>&nbsp;&nbsp;&nbsp; 自行车Bicycle</p>
<p>&nbsp;&nbsp;&nbsp; Public class Bicycle{</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; public void expand(Pump pump){</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; pump.blow();</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p>
<p>&nbsp;&nbsp; &nbsp;}</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp;&nbsp; 打气筒Pump</p>
<p>&nbsp;&nbsp;&nbsp; Public class Pump{</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; public void blow(){</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; System.out.println(&quot;打气实现打气的功能&quot;);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } </p>
<p>&nbsp;&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p><strong>&lt;4&gt;.关联关系</strong></p>
<p>对于两个相对独立的系统，当一个系统的实例与另一个系统的一些特定实例存在固定的对应关系时，这两个系统之间为<strong>关联关系</strong>。</p>
<p>在 UML 中关联关系用<strong>一条实线箭头由一方指向多方，或者</strong>用<strong>一条实线连接</strong></p>
<p><strong>例如</strong>客户和订单，每个订单对应特定的客户，每个客户对应一些特定的订单</p>
<p>&nbsp;</p>
<p>单向关联：<strong>一对多</strong>的关联</p>
<p>&nbsp;<img height="68" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89678/1dec9e2d-be6a-35bd-b926-4918ee63c58b.png" width="340"></p>
<p>单向关联,<strong>多对一</strong>的关联差不多，这里就不举例了。</p>
<p>双向关联</p>
<p>&nbsp;<img height="67" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89680/fcb14eb8-024a-3915-8ecd-35a16b6360fe.png" width="329"></p>
<p>&nbsp;</p>
<p><strong>1&gt;.关联关系的角色</strong></p>
<p>当一个类处于关联的某一端时, 该类就在这个关系中扮演一个特定的角色. 具体来说, <strong>角色就是关联关系中一个类对另一个类所表现的职责</strong>. 角色名称是名词或名称短语.</p>
<p>&nbsp;<img height="92" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89682/33d7594d-fee3-3137-8617-5fd88fc256be.png" width="520"></p>
<p>&nbsp;</p>
<p><strong>2&gt;.关联关系的多重性</strong></p>
<p>关联关系的多重性是<strong>指有多少对象可以参与该关联</strong>, 多重性可以用来表达一个取&#20540;范围, 特定&#20540;, 无限定的范围.</p>
<p>&nbsp;</p>
<p>&nbsp;<img height="166" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89684/c8670776-4790-3fc0-9215-a24fd838e420.png" width="458"></p>
<p><img height="89" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89686/0764020d-1ec2-32d3-8ee0-5a5041f76b58.png" width="517"></p>
<p><strong>&nbsp;</strong></p>
<p><strong>3&gt;.关联关系的聚合关系</strong></p>
<p><strong>聚合关联</strong>是一种特殊的关联. 它表示类间的关系是<strong>整体与部分</strong>的关系. <strong>简言之</strong>: 关联关系中的一个类描述了一个较大的事物, 它由较小的事物组成<strong>.
</strong></p>
<p>聚合关系描述了 “has a” 的关系, 即整体对象拥有部分对象</p>
<p>整体和部分之间用<strong>空心菱形箭头的连线连接</strong>, <strong>箭头指向部分</strong></p>
<p>&nbsp;<img height="68" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89688/5c0bab27-3374-3dbf-9817-40c38492a64c.png" width="274"></p>
<p>&nbsp;</p>
<p><strong>4&gt;.关联关系的组成关系(也叫组合关系)</strong></p>
<p><strong>组成关系</strong>是<strong>更强形式的聚合.</strong> </p>
<p>组成关系中, 整件拥有部件的生命周期, 所以整件删除时, 部件一定会跟着删除. 而且, 多个整件不可以同时共享同一个部件。</p>
<p>聚合关系中, 整件不会拥有部件的生命周期, 所以整件删除时, 部件不会被删除. 再者, 多个整件可以共享同一个部件.</p>
<p>UML 中组成关系用<strong>实心的菱形实线表示</strong>, <strong>箭头指向部分</strong></p>
<p>&nbsp;<img height="45" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89691/fb7b99de-7686-3630-a8bb-37189ffa5b3c.png" width="253"></p>
<p><strong>5&gt;.关联关系的导航性</strong></p>
<p><strong>导航性表示可从源类的任何对象到目标类的一个或多个对象遍历. 即: 给定源类的一个对象, 可以得到目标类的所有对象. 可以在关联关系上加上箭头表示导航方向.
</strong></p>
<p><strong>只在一个方向上可以导航的关联称为单向关联,用一个带箭头的方向表示; </strong></p>
<p><strong><img height="58" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89694/ff49052a-941e-3a11-b91e-e5d337e633ea.png" width="203"></strong></p>
<p><img height="58" alt="" src="http://z-xiaofei168.iteye.com/upload/picture/pic/89696/ec49f4a7-d759-393e-8917-221f28f4717b.png" width="202"></p>
<p>&nbsp;</p>
   
</div>