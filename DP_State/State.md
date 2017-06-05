<div class="blog_main">
  <div class="blog_title">
    <h3>
      <a href="/blog/1328563">状态模式——State (更好的实现状态机)</a>
      <em class="actions">      </em>
    </h3>
    <ul class='blog_categories'><strong>博客分类：</strong> <li><a href="/category/159053">设计模式(抽象&amp;封装)</a></li> </ul>
     

  <div id="blog_content" class="blog_content">
    <p class="MsoNormal"><span style="font-size: small;"><span>1. </span>
<span>概述</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
The intent of the STATE
pattern is to distribute state-specific logic across classes that represent an
object’s state.</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
<span style="color: red;">STATE</span>
</span>
<span>设计模式的目的</span>
<span>是：将特定状态相关的逻辑分散到一些类的状态类中。</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span> </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span>2. </span>
<span>实例</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
</span>
<span>旋转门：</span>
<span>Consider the model of the
state of a carousel door(revolving door). A carousel is a large, smart rack that accepts
material through a doorway and stores the material according to a bar code ID
on it. The door operates with a single button. See the state diagram below for
some detail.</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span> </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
</span>
<span>旋转门的状态图：（状态图细节见</span>
<span>4.</span>
<span>）</span>
</span>
</p>
<p class="MsoNormal"><br><img alt="" src="http://dl.iteye.com/upload/attachment/612921/0f31f3ab-c496-31eb-bc45-6442cf3be84d.png"></p>
<p class="MsoNormal"><span style="font-size: small;"><span> </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span>3. </span>
<span>状态模型的两种实现方法</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
3.1 </span>
<span>方法一：</span>
<span>switch</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span> </span>
</span>
<br><img alt="" src="http://dl.iteye.com/upload/attachment/612924/fde21594-aecc-3cce-88e7-d8e393bcd570.png"></p>
<p class="MsoNormal">Observable是java.util中的类^^居然以前都不晓得哦，该打！</p>
<p class="MsoNormal"> </p>
<p class="MsoNormal">Door的具体实现如下：</p>
<pre class="java" name="code">import java.util.Observable;

/**
 * This class provides an initial model of a carousel door
 * that manages its state without moving state-specific
 * logic out to state classes.
 */
public class Door extends Observable {
    public final int CLOSED = -1;
    public final int OPENING = -2;
    public final int OPEN = -3;
    public final int CLOSING = -4;
    public final int STAYOPEN = -5;

    private int state = CLOSED;

    /**
     * The carousel user has touched the carousel button. This "one touch"
     * button elicits different behaviors, depending on the state of the door.
     */
    public void touch() {
        switch (state)
        {
            case OPENING:
            case STAYOPEN:
                setState(CLOSING);
                break;
            case CLOSING:
            case CLOSED:
                setState(OPENING);
                break;
            case OPEN:
                setState(STAYOPEN);
                break;
            default:
                throw new Error("can't happen");
        }
    }

    /** 
     * This is a notification from the mechanical carousel that 
     * the door finished opening or shutting.
     */
    public void complete() {
        if (state == OPENING)
            setState(OPEN);
        else if (state == CLOSING)
            setState(CLOSED);
    }

    /**
     * This is a notification from the mechanical carousel that the
     * door got tired of being open.
     */
        public void timeout() {
            setState(CLOSING);
        }
     
    /**
     * @return a textual description of the door's state
     */
    public String status()
    {
        switch (state)
        {
            case OPENING:
                return "Opening";
            case OPEN:
                return "Open";
            case CLOSING:
                return "Closing";
            case STAYOPEN:
                return "StayOpen";
            default:
                return "Closed";
        }
    }

    private void setState(int state)
    {
        this.state = state;
        setChanged();
        notifyObservers();
    }
}</pre>
 
<p class="MsoNormal">但是采用这种实现，有一个缺陷：state变量在Door类的实现中浑身扩散，就像癌症一般！</p>
<p class="MsoNormal"> </p>
<p> </p>
<p class="MsoNormal"><span><span>    </span>
3.2 </span>
<span>方法二：</span>
<span>State Pattern</span>
</p>
<p class="MsoNormal"><span> </span>
</p>
<p>
<span style="font-size: 10.5pt;"><span>    </span>
A. </span>
<span>基本的</span>
<span style="font-size: 10.5pt;">State
Pattern</span>
<span>实现</span>
</p>
<p><br><img alt="" src="http://dl.iteye.com/upload/attachment/613031/80e517f4-88e3-30f1-9069-d409a1e0f9c2.png"></p>
<p> </p>
<p class="MsoNormal"><span><span>    </span>
</span>
<span>以上设计方式要求每个状态子类实例内部“</span>
<span>hold</span>
<span>住”一个</span>
<span>Door2</span>
<span>实例的引用，这样才能完成</span>
<span>Door2</span>
<span>实例和它的各个状态实例时间的互相通信。这种设计要求一个状态实例对应一个</span>
<span>Door2</span>
<span>实例，这样一来，一个状态实例就只能为一个</span>
<span>Door2</span>
<span>实例服务╮</span>
<span>(</span>
<span>╯▽╰</span>
<span>)</span>
<span>╭</span>
</p>
<p>
<span style="font-size: 10.5pt;"><span>    </span>
</span>
<span>客户端这样调用：</span>
</p>
<pre class="java" name="code">public static void main(String[] args){
    	Door2 door=new Door2();
    	
    	//1. 初始状态
    	System.out.println(door.status());
    	
    	//2. 转移到Opening状态
    	door.touch();
    	System.out.println(door.status());
    	
    	//3. 转移到Open状态
    	door.complete();
    	System.out.println(door.status());
    	
    	//4. 转移到Closing状态
    	door.timeout();
    	System.out.println(door.status());
    	
    	//5. 回到Closed状态
    	door.complete();
    	System.out.println(door.status());
    }
</pre>
<p> </p>
<p> </p>
<p>下面给出Door2类、DoorState抽象类、DoorStayOpen类的实现：</p>
<p>Door2:</p>
<pre class="java" name="code">public class Door2 extends Observable {
    public final DoorState CLOSED = new DoorClosed(this);
    public final DoorState CLOSING = new DoorClosing(this);
    public final DoorState OPEN = new DoorOpen(this);
    public final DoorState OPENING = new DoorOpening(this);
    public final DoorState STAYOPEN = new DoorStayOpen(this);

    private DoorState state = CLOSED;

    public void touch() {
        state.touch();
    }

    public void complete() {
        state.complete();
    }

    public void timeout() {
        state.timeout();
    }

    public String status() {
        return state.status();
    }

    protected void setState(DoorState state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }</pre>
<p> </p>
<p>DoorState抽象类：</p>
<pre class="java" name="code">public abstract class DoorState {
    protected Door2 door;

    public abstract void touch();

    public void complete() {
    }

    public void timeout() {
    }

    public String status() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf('.') + 1);
    }

    public DoorState(Door2 door) {
        this.door = door;
    }
}</pre>
 
<p>DoorStayOpen类：</p>
<pre class="java" name="code">public class DoorStayOpen extends DoorState {
    public DoorStayOpen(Door2 door) {
        super(door);
    }

    public void touch() {
        door.setState(door.CLOSING);
    }
}</pre>
 
<p> </p>
<p class="MsoNormal"><span><span>    </span>
B. State Pattern</span>
<span>实现</span>
<span>2</span>
<span>——让状态实例（</span>
<span>DoorState</span>
<span>的子类实例）为多个</span>
<span>Door2</span>
<span>实例服务</span>
</p>
<p class="MsoNormal"><span><span>    </span>
</span>
<span>子状态</span>
<span>DoorOpen</span>
<span>实现转移时只负责返回下目标状态是什么，将状态转移的</span>
<span>action</span>
<span>留给</span>
<span>Door2</span>
<span>实例自己来做；而不是像“</span>
<span>A. </span>
<span>基本的</span>
<span>State Pattern</span>
<span>实现”那样在</span>
<span>DoorOpen</span>
<span>内部保存一个</span>
<span>Door2</span>
<span>实例的引用</span>
<span>door</span>
<span>，亲自调用</span>
<span>door.setState(door.STAYOPEN);</span>
<span>来实现状态转移</span>
</p>
<p class="MsoNormal"><span><span>    </span>
</span>
<span>改进后的关键代码：</span>
</p>
<p class="MsoNormal"><span><span>    </span>
</span></p>
<pre class="java" name="code">public class DoorOpen extends DoorState{
       public DoorState touch(){
           return DoorState.STAYOPEN;
           // 以前是 door.setState(door.STAYOPEN);
       }
       ...
}

 

    public class Door2 extends Observable{
       public void touch(){
           state=state.touch();
           // 以前是 state.touch();
           // 即将转移状态的工作留给状态实例来做，事不关己高高挂起
       }
} </pre>
<p class="MsoNormal"> </p>
 
<p class="MsoNormal"><span><span>    </span>
C. State Pattern</span>
<span>实现</span>
<span>3</span>
<span>——让状态实例（</span>
<span>DoorState</span>
<span>的子类实例）为多个</span>
<span>Door2</span>
<span>实例服务</span>
</p>
<p class="MsoNormal"><span><span>    </span>
</span>
<span>另一种实现这种效果的方法是：将</span>
<span>Door2</span>
<span>实例作为参数传递给</span>
<span>DoorState</span>
<span>的状态转移方法，而非建立</span>
<span>Composite</span>
<span>的关联关系（将</span>
<span>DoorState</span>
<span>的子类对象作为</span>
<span>Door2</span>
<span>的属性）。</span>
</p>
<p class="MsoNormal"><span><span>    </span>
</span>
<span>也即，用“</span>
<span>Dependency</span>
<span>依赖”（弱依赖，如调用）代替了“</span>
<span>Association</span>
<span>关联”（强依赖，如作为属性进行组合）。</span>
</p>
<p class="MsoNormal"><span> </span>
</p>
<p> </p>
<p class="MsoNormal"> </p>
<p class="MsoNormal"><span style="font-size: small;"><span>4. </span>
<span>状态图细节</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
</span>
<span>何谓</span>
<span>State</span>
<span>状态</span>
<span>:
Generally speaking, the state of an object depends on the collective value of
the object</span>
<span>’</span>
<span>s
instance variables. In some cases, most of an object</span>
<span>’</span>
<span>s attributes are fairly
static once set, and one attribute is dynamic and plays a prominent role in the
class</span>
<span>’</span>
<span>s
logic. This attribute may represent the state of the entire object and may even
be named state. </span>
</span>
</p>
<p class="MsoNormal"><br><img alt="" src="http://dl.iteye.com/upload/attachment/612926/017dd22f-d41c-3ef6-8b16-f4be3778f1dd.png"><br><img style="float: right;" alt="" src="http://dl.iteye.com/upload/attachment/612928/a0d758c2-1008-3b3a-9201-fae2c8f981b3.png"></p>
<p class="MsoNormal"><span style="font-size: small;"><span> </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
4.1 State</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
You can subdivide a state icon into areas that
show the <span style="color: red;">state</span>
</span>
<span style="color: red;">’</span>
<span>s name</span>
<span>
and <span style="color: red;">activities</span>
</span>
<span>活动</span>
<span>. </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
3 frequently used categories of activities
are <span style="color: red;">entry</span>
 (what happens when the system enters
the state), <span style="color: red;">exit </span>
(what happens when the system
leaves the state), and <span style="color: red;">do </span>
(what happens while
the system is in the state). </span>
</span>
</p>
<p class="MsoNormal"><br><img alt="" src="http://dl.iteye.com/upload/attachment/612930/e2f30368-d2d8-35b4-b380-f346f3ed3fe9.png"></p>
<p class="MsoNormal"><span style="font-size: small;"><span> </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
4.2 <span style="color: red;">Transition</span>
s (Details: Event[Guard Condition]/Action)</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
You can also add some
details to the transition lines. You can indicate an event that causes a transition
to occur (a <span style="color: red;">trigger event</span>
) and the computation (the
<span style="color: red;">action</span>
) that executes and makes the state change
happen. </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span><span>    </span>
A <span style="color: red;">guard
condition</span>
: when it’s met, the transition takes place.</span>
<span>通常将超时作为监护条件，∵可以认为此时没有任何</span>
<span>event.</span>
</span>
</p>
<p class="MsoNormal"><br><img alt="" src="http://dl.iteye.com/upload/attachment/612934/8bd0d859-4393-3f23-9e03-50cce23fe174.png"></p>
<p class="MsoNormal"><span style="font-size: small;"><span>?源状态</span>
<span>Source State</span>
<span>：即受转换影响的状态</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span>?目标状态</span>
<span>Target State</span>
<span>：当转换完成后，对象的状态</span>
<span> </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span>?触发事件</span>
<span>(Trigger) Event</span>
<span>：用来为转换定义一个事件，包括调用、改变、信号、时间四类事件</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span>?监护条件</span>
<span>(Guard Condition)</span>
<span>：布尔表达式，决定是否激活转换、</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span>?动作</span>
<span>(Action)</span>
<span>：转换激活时的操作</span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span> </span>
</span>
</p>
<p class="MsoNormal"><span style="font-size: small;"><span>几个实例：</span>
</span>
</p>
<p class="MsoNormal"><br><img alt="" src="http://dl.iteye.com/upload/attachment/612936/35324baa-490c-3151-a924-18e61792e5e9.png"><br>
 <br><img alt="" src="http://dl.iteye.com/upload/attachment/612938/e65b09d5-2368-34cc-b18d-2a6e1e920952.png"></p>
<p class="MsoNormal"> </p>
<p class="MsoNormal"><br><img alt="" src="http://dl.iteye.com/upload/attachment/616189/d6e8371c-2e43-359f-a1d5-35499898acd3.png"></p>
<p class="MsoNormal"><span style="font-size: small;"><span> </span>
</span>
</p>
  </div>