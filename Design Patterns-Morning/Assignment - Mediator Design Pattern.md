# Mediator Design Pattern
The Mediator Design Pattern provides solution to the problems associated with tight coupling - higher maintenance cost and difficulty to extend. It incorporates loose coupling by disallowing objects from explicitly referring to each other. It thus allows us to vary their interaction independently.

This is achieved by designing an intermediatory layer in between through which all the interaction happen.

### Structure
![](https://github.com/rg-acc/AU-July-2020/blob/master/Design%20Patterns-Morning/structure.png?raw=true)

- There's no coupling between the peers. 
- Each peer can only interact with the Mediator
- The Mediator acts as a bridge between the peers and is reponsible for orchestrating the conversation. 
- There's no many to many mapping between colleagues. Infact, it has been transformed to full object status. 
- This approach thus provides a base of indirection for object interaction.

### Example
![](https://github.com/rg-acc/AU-July-2020/blob/master/Design%20Patterns-Morning/atc.png?raw=true)

For instance, take the example of Air traffic controller. Here, the airport control room works as a mediator for communication between different flights. The planes departing/approaching the terminal area communicate directly with the control room and not with one another. The control room enforces who can land and tak off. It is interesting to note that although the communication room enforces its constraints only in the terminal area, it is not responsible for controllling the whole flight as such.

### Advantage
The Mediator design pattern limits subclassing by localizing the behavior using a Mediator. Now, when changing the behaviour, we just need to subclass the Mediator. The Peers can be reused as it is.

### Disadvantage
As much as the use of Mediator helps, its disadvantage is that it centralizes control. There's a trade off between Mediator complexity & interaction complexity. The Mediator can become quite complex because of protocol encapsulation  which would result in high maintenance.

### Disadvantage
Now let's look at the code to make this simpler. This is an implementation of Air Traffic Controller example discussed earlier:

```sh
class ATCMediator implements IATCMediator 
{ 
	private Flight flight; 
	private Runway runway; 
	public boolean land; 

	public void registerRunway(Runway runway) 
	{ 
		this.runway = runway; 
	} 

	public void registerFlight(Flight flight) 
	{ 
		this.flight = flight; 
	} 

	public boolean isLandingOk() 
	{ 
		return land; 
	} 

	@Override
	public void setLandingStatus(boolean status) 
	{ 
		land = status; 
	} 
} 

interface Command 
{ 
	void land(); 
} 

interface IATCMediator 
{ 

	public void registerRunway(Runway runway); 

	public void registerFlight(Flight flight); 

	public boolean isLandingOk(); 

	public void setLandingStatus(boolean status); 
} 

class Flight implements Command 
{ 
	private IATCMediator atcMediator; 

	public Flight(IATCMediator atcMediator) 
	{ 
		this.atcMediator = atcMediator; 
	} 

	public void land() 
	{ 
		if (atcMediator.isLandingOk()) 
		{ 
			System.out.println("Successfully Landed."); 
			atcMediator.setLandingStatus(true); 
		} 
		else
			System.out.println("Waiting for landing."); 
	} 

	public void getReady() 
	{ 
		System.out.println("Ready for landing."); 
	} 

} 

class Runway implements Command 
{ 
	private IATCMediator atcMediator; 

	public Runway(IATCMediator atcMediator) 
	{ 
		this.atcMediator = atcMediator; 
		atcMediator.setLandingStatus(true); 
	} 

	@Override
	public void land() 
	{ 
		System.out.println("Landing permission granted."); 
		atcMediator.setLandingStatus(true); 
	} 

} 

class MediatorDesignPattern 
{ 
	public static void main(String args[]) 
	{ 

		IATCMediator atcMediator = new ATCMediator(); 
		Flight sparrow101 = new Flight(atcMediator); 
		Runway mainRunway = new Runway(atcMediator); 
		atcMediator.registerFlight(sparrow101); 
		atcMediator.registerRunway(mainRunway); 
		sparrow101.getReady(); 
		mainRunway.land(); 
		sparrow101.land(); 
		
	} 
} 
```
#### output

```sh
Ready for landing.
Landing permission granted.
Successfully Landed.
```

### References
https://sourcemaking.com/design_patterns/mediator<br/>
https://www.geeksforgeeks.org/mediator-design-pattern/


