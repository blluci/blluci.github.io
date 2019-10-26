// Case A --------------------
Invoice f = new Invoice( workOrders ); 
f.setDate( Dates.today() );

EntityManager em = emf.createEntityManager();
EntityTransaction trx = em.getTransaction(); trx.begin();

em.persist( f );
f.setDate( Dates.yesterday() );

trx.commit();
em.close();

f.setDate( Dates.tomorrow() );
Console.println( f.toString() );

em = emf.createEntityManager();
trx = em.getTransaction(); trx.begin();

em.merge( f );
f.setDate( Dates.today() );

trx.commit();
em.close();

em = emf.createEntityManager();
trx = em.getTransaction(); trx.begin();

f = em.find(Invoice.class, f.getId() );
f.setDate( Dates.today() );

trx.commit();
em.close();

em = emf.createEntityManager();
trx = em.getTransaction(); trx.begin();

f = em.merge( f );
em.remove( f );

trx.commit();
em.close();

// Case B --------------------------
EntityManager em = emf.createEntityManager();
EntityTransaction trx = em.getTransaction(); trx.begin():

Invoice f = em.find(Invoice.class, 123);
f.setDate( Dates.today() );

trx.commit();
em.close();

f.setDate( Dates.yesterday() );
Console.println( f.toString() );

em = emf.createEntityManager();
trx = em.getTransaction(); trx.begin();

em.merge( f );

trx.commit();
em.close();

// Case C --------------------------
EntityManager em = emf.createEntityManager();
EntityTransaction trx = em.getTransaction(); trx.begin():

Invoice f = em.find(Invoice.class, 123)

trx.commit();
em.close();

f.setDate( Dates.today() );

em = emf.createEntityManager();
trx = em.getTransaction(); trx.begin():

Invoice f2 = em.find(Invoice.class, 123)
Invoice f3 = em.merge( f );

assert( f == f2 );
assert( f2 == f3 );

trx.commit();
em.close();

// Case D --------------------------
EntityManager em = emf.createEntityManager();
EntityTransaction trx = em.getTransaction(); trx.begin():

Invoice f = em.find(Invoice.class, 123);
for(WorkOrder a: f.getWorkOrders() ) {
	a.getVehicle().getVehicleType().setPricePerHour( 50.0 );
}

trx.commit();
em.close();

// Case E --------------------------
EntityManager em = emf.createEntityManager();
EntityTransaction trx = em.getTransaction(); trx.begin():

Invoice f = em.find(Invoice.class, 123);

trx.commit();
em.close();

for(WorkOrder a: f.getWorkOrders() ) {
	Console.println( a.getVehicle().getPlate() );
}

// Case F --------------------------
EntityManager em = emf.createEntityManager();
EntityTransaction trx = em.getTransaction(); trx.begin():

Invoice f = em.find(Invoice.class, 123);
Set<WorkOrder> workOrders = f.getWorkOrders();

Query q = em.createQuery("select f from Invoice f where f.id = 123");
Invoice f2 = q.getSingleResult();

assert( f == f2 ); 
assert( f2.getWorkOrders().equals( workOrders ) );

trx.commit();
em.close();

// Case G ------------------------
package uo.ri.presentation;
public class ShowInterventionsAction {
	Long id = 123; // Console.askForLong("Work order id")
	
	Service s = Factory.getService();
	WorkOrder a = s.findById( id );
	for(Intervention i : a.getInterventions() ) {
		Printer.print( i );
	}
}

package uo.ri.business;
public class Service {
	...
	public WorkOrder findById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction(); 
		trx.begin():

		WorkOrder a = em.find(WorkOrder.class, id);

		trx.commit();
		em.close();
		
		return a;
	}
	...
}