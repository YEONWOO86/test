package jdbc.test.template;

public class TestTemplate {
	public static void main(String[] args) {
	
	Worker design = new Designer();
	design.work();
	Worker program = new Programmer();
	program.work();
	
	}
}
