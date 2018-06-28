package pl.myrecipebasket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyRecipeBasketAppApplication {
	
	public static ConfigurableApplicationContext ctx;
	
	public static void main(String[] args) {
		ctx = SpringApplication.run(MyRecipeBasketAppApplication.class, args);
	}
	
	
}
