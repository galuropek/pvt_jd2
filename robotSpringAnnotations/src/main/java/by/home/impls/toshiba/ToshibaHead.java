package by.home.impls.toshiba;

import by.home.interfaces.Head;
import org.springframework.stereotype.Component;

@Component
public class ToshibaHead implements Head {
	
	public void calc(){
		System.out.println("Thinking about Toshiba...");
	}

}
