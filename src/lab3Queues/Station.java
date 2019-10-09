package lab3Queues;

public class Station {
	private String name;
	private LinkedQueue<Passenger> passengers = new LinkedQueue<>();
	
	public Station(String s) {
		name = s;
	}
	
	public void fill() {
		
	}
	
	public void add( Passenger anEntry )
	{
		passengers.enqueue(anEntry);
	}
	
	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.println("----------------------");
		System.out.println(name);
		System.out.println("" + '\t' + "Passengers:" + '\n');
		if (!passengers.isEmpty())
		{
			Passenger placeholder = passengers.getFront();
			Passenger temp;
			do
			{
				temp = passengers.dequeue();
				System.out.print(temp.toString());
				passengers.enqueue(temp);
			}while( !passengers.getFront().equals(placeholder) );
		}
		System.out.println("===================");
	}
}
