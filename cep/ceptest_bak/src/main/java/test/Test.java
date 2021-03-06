package test;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPOnDemandQueryResult;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * @author luonanqin
 */
class TestEvent {

	private double price;
	private String type;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

class testListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if (newEvents != null) {
			for (int i = 0; i < newEvents.length; i++) {
				EventBean newEvent = newEvents[i];
				System.out.println(newEvent.getUnderlying());
			}
		}
	}
}

class MergeListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if (newEvents != null) {
			for (int i = 0; i < newEvents.length; i++) {
				EventBean newEvent = newEvents[i];
				System.out.println(newEvent);
			}
		}
	}
}

class TestListener2 implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if (newEvents != null) {
			for (int i = 0; i < newEvents.length; i++) {
				EventBean newEvent = newEvents[i];
				System.out.println(newEvent);
			}
		}
	}
}

class TestListener3 implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if (newEvents != null) {
			for (int i = 0; i < newEvents.length; i++) {
				EventBean newEvent = newEvents[i];
				System.out.println(newEvent);
			}
		}
	}
}

class BCDListener implements UpdateListener {

	private EPRuntime runtime;

	public BCDListener(EPRuntime runtime) {
		this.runtime = runtime;
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		A a = new A();
		a.setId(11);
		runtime.sendEvent(a);
	}
}

class EFGListener implements UpdateListener {

	private EPRuntime runtime;

	public EFGListener(EPRuntime runtime) {
		this.runtime = runtime;
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		B b = new B();
		b.setId(21);
		b.setFlag("BCD");
		runtime.sendEvent(b);
	}
}

class HIListener implements UpdateListener {

	private EPRuntime runtime;

	public HIListener(EPRuntime runtime) {
		this.runtime = runtime;
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		C c = new C();
		c.setId(22);
		c.setFlag("BCD");
		runtime.sendEvent(c);
	}
}

class DListener implements UpdateListener {

	private EPRuntime runtime;

	public DListener(EPRuntime runtime) {
		this.runtime = runtime;
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		D d = new D();
		d.setId(23);
		d.setFlag("BCD");
		runtime.sendEvent(d);
	}
}

interface ID {
	int getId();

	String getFlag();
}

class A implements ID {
	private int id;
	private B b;
	private C c;
	private D d;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public void setD(D d) {
		this.d = d;
	}

	public D getD() {
		return d;
	}
}

class B implements ID {
	private int id;
	private E e;
	private F f;
	private G g;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}

	public F getF() {
		return f;
	}

	public void setF(F f) {
		this.f = f;
	}

	public G getG() {
		return g;
	}

	public void setG(G g) {
		this.g = g;
	}
}

class C implements ID {
	private int id;
	private H h;
	private I i;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public H getH() {
		return h;
	}

	public void setH(H h) {
		this.h = h;
	}

	public I getI() {
		return i;
	}

	public void setI(I i) {
		this.i = i;
	}
}

class D implements ID {
	private int id;
	private I i;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public I getI() {
		return i;
	}

	public void setI(I i) {
		this.i = i;
	}
}

class E implements ID {
	private int id;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

class F implements ID {
	private int id;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

class G implements ID {
	private int id;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

class H implements ID {
	private int id;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

class I implements ID {
	private int id;
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Configuration config = new Configuration();
		config.configure("esper.examples.cfg.xml");

		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
		EPRuntime runtime = epService.getEPRuntime();
		EPAdministrator admin = epService.getEPAdministrator();

		String id = ID.class.getName();

		String epl1 = "select * from pattern[every (B and C and D)]";
		String epl2 = "select * from pattern[every (E and F and G)]";
		String epl3 = "select * from pattern[every (H and I)]";
		String epl5 = "select * from pattern[every I]";

		String epl4 = "select * from pattern[(every i=" + B.class.getName() + ") where timer:within(1 sec)]";
		// String epl4 = "every " + id;
		// String epl4 = "select * from pattern[every " + id + "(id>0)]";
		// System.out.println(epl4);

		// EPStatement state1 = admin.createEPL(epl1);
		// state1.addListener(new testListener());

		// EPStatement state2 = admin.createEPL(epl4);
		// state2.addListener(new TestListener2());
		// EPStatement state2 = admin.createPattern(epl4);
		// state2.addListener(new TestListener2());

		// String epl6 = "select * from pattern[every H and (I where timer:within(3 sec))]";
		// admin.createEPL(epl6);

		String epl15 = "@Priority(50) on " + id + "(id=11) set BCDFlag = '!BCD'";
		String epl16 = "@Priority(49) on " + id + "(id=21 or id=11) set EFGFlag = '!EFG'";
		String epl17 = "@Priority(48) on " + id + "(id=22 or id=11) set HIFlag = '!HI'";
		admin.createEPL(epl15);
		admin.createEPL(epl16);
		admin.createEPL(epl17);

		String epl7 = "@Priority(41) select * from " + id + "(id in [21,22,23] and flag = BCDFlag).std:unique(id).win:length_batch(3)";
		EPStatement state3 = admin.createEPL(epl7);
		state3.addListener(new BCDListener(runtime));

		String epl8 = "@Priority(42) select * from " + id + "(id in [31,32,33] and flag = EFGFlag).std:unique(id).win:length_batch(3)";
		EPStatement state4 = admin.createEPL(epl8);
		state4.addListener(new EFGListener(runtime));

		String epl9 = "@Priority(43) select * from " + id + "(id in [34,35] and flag = HIFlag).std:unique(id).win:length_batch(2)";
		EPStatement state5 = admin.createEPL(epl9);
		state5.addListener(new HIListener(runtime));

		String epl10 = "@Priority(44) select * from " + id + "(id in [35]).std:unique(id).win:length_batch(1)";
		EPStatement state6 = admin.createEPL(epl10);
		state6.addListener(new DListener(runtime));

		// String epl11 = "￼@Priority(10) select * from " + id;
		// EPStatement state7 = admin.createEPL(epl11);
		// state7.addListener(new TestListener2());

		String epl12 = "create window TestWindow.std:unique(id).win:keepall() as " + id + "";
		admin.createEPL(epl12);

		String epl13 = "@Priority(45) insert into TestWindow select * from " + id + " where id != 35 and (flag=BCDFlag or flag=EFGFlag or flag=HIFlag)";
		EPStatement state8 = admin.createEPL(epl13);
		state8.addListener(new TestListener2());

		// String epl14 = "@Priority(39) on " + id + "(id>0) inputID merge TestWindow tw"
		// + " when matched and inputID.id=21 then delete where tw.id=31 then delete where tw.id=32 then delete where tw.id=33";
		// + " when matched and inputID.id=21 then delete where tw.id=33 ";
		// + " when matched and inputID.id=21 then insert select *";
		String epl14 = "@Priority(39) on " + id + "(id>0) inputID merge TestWindow tw"
		  + " when matched and inputID.id=11 then delete where tw.id=21 then delete where tw.id=22 then delete where tw.id=23"
		  + " when matched and inputID.id=21 then delete where tw.id=31 then delete where tw.id=32 then delete where tw.id=33"
		  + " when matched and (inputID.id=22 or inputID.id=11) then delete where tw.id=34 then delete where tw.id=35";
		EPStatement state9 = admin.createEPL(epl14);
		state9.addListener(new MergeListener());

		A a = new A();
		a.setId(11);
		a.setFlag("A");
		B b = new B();
		b.setFlag("BCD");
		b.setId(21);
		C c = new C();
		c.setId(22);
		c.setFlag("BCD");
		D d = new D();
		d.setId(23);
		d.setFlag("BCD");
		E e = new E();
		e.setId(31);
		e.setFlag("EFG");
		F f = new F();
		f.setId(32);
		f.setFlag("EFG");
		G g = new G();
		g.setId(33);
		g.setFlag("EFG");
		H h = new H();
		h.setId(34);
		h.setFlag("HI");
		I i = new I();
		i.setId(35);
		i.setFlag("HI");

		String select = "select * from TestWindow";
		EPOnDemandQueryResult result;
		EventBean[] events;

		B b1 = new B();
		b1.setId(21);
		b1.setFlag("BCD");
		// runtime.sendEvent(b1);

		runtime.sendEvent(e);
		runtime.sendEvent(f);

		result = epService.getEPRuntime().executeQuery(select);
		events = result.getArray();

		runtime.sendEvent(g);

		result = epService.getEPRuntime().executeQuery(select);
		events = result.getArray();

		// runtime.sendEvent(b);
		// runtime.sendEvent(h);
		// runtime.sendEvent(a);
		// runtime.sendEvent(d);
		runtime.sendEvent(i);
		// runtime.sendEvent(c);
		// runtime.sendEvent(d);

		result = epService.getEPRuntime().executeQuery(select);
		events = result.getArray();
		for (int j = 0; j < events.length; j++) {
			EventBean event = events[j];
			System.out.println(event.getUnderlying());
		}

	}
}
