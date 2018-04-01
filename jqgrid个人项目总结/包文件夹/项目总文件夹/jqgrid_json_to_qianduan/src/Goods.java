
public class Goods {
	private int id;
	private String type;
	private double pay;
	private String name;
	private String text;
	public Goods()
	{}
	public Goods(int id, String type, double pay, String name, String text) {
		super();
		this.id = id;
		this.type = type;
		this.pay = pay;
		this.name = name;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", type=" + type + ", pay=" + pay + ", name=" + name + ", text=" + text + "]";
	}
}
