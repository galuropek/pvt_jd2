package by.home.impls.toshiba;

import by.home.interfaces.Hand;
import org.springframework.stereotype.Component;

@Component
public class ToshibaHand implements Hand {
	
	public void catchSomething(){
		System.out.println("Catched from Toshiba!");
	}

}
