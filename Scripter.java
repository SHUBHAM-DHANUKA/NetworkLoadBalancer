
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author techie-monk Founder of Cosec and LKI foundation 
 *
 */
class ScheduledTaskExample {
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	// Client is running********************************************************************************

	public void clientTask() {
		@SuppressWarnings("unused")
		final ScheduledFuture<?> taskHandle = scheduler.scheduleAtFixedRate(
				new Runnable() {
					@Override
					public void run() {
						try {
							System.out.println("client working");
				   			 Process proc = Runtime.getRuntime().exec("/home/techie-monk/Downloads/NetworkLoadBalancer/client_listening.sh"); //Whatever you want to execute
				 			//Process proc2 = Runtime.getRuntime().exec("/home/techie-monk/eclipse-workspace/NetworkLoadBalancer/client_listening2.sh");
                                                        proc.waitFor();
                                                       // proc2.waitFor();
                                                        proc.destroy();
                                                       // proc2.destroy();   
						}catch(Exception ex) {
							ex.printStackTrace(); //or loggger would be better
						}
					}
				}, 0, 10, TimeUnit.SECONDS);
	}


//Server is running********************************************************************************


public void ServerTask() {
	@SuppressWarnings("unused")
	final ScheduledFuture<?> taskHandle = scheduler.scheduleAtFixedRate(
			new Runnable() {
				@Override
				public void run() {
					try {
						
			   			 Process sp = Runtime.getRuntime().exec("/home/techie-monk/Downloads/NetworkLoadBalancer/server_listening.sh"); //Whatever you want to execute
                         
					}catch(Exception ex) {
						ex.printStackTrace(); //or loggger would be better
					}
				}
			}, 0, 1, TimeUnit.SECONDS);
}


//Decider is running********************************************************************************


}
public class Scripter {
	public static void main(String[] args) throws Exception {
		ScheduledTaskExample ste = new ScheduledTaskExample();
		ste.ServerTask();
		ste.clientTask();
      
	
	}
}
