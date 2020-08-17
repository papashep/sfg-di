package com.melvyn.sfgdi;
/*
	Dependency Injection
	Initially setup by Spring modified by Melvyn
 */

import com.melvyn.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by Melvyn on 10/Aug/2020
 */

/*
	For an example we moved the 'services' package up to the 'com.melvyn' level removing it from the 'sfgdi' package.
	Without the @ComponentScan line the application failed because Spring Boot could not see the 'services' package.
	By adding the @ComponentScan annotation and by specifying:
	@SpringBootApplication      // Scan the package / subpackages and down. It will not scan packages on the same level.
	@ComponentScan(basePackages = {"com.melvyn.sfgdi.services", "com.melvyn"}) this will now include all the packages
									listed above and override the @SpringBootApplication scan.

	Note: the code has been reverted back to its original state before using the @ComponentScan
	===========================================================================================
*/

@SpringBootApplication        // Scan the package / subpackages and down. It will not scan packages on the same level.
public class SfgDiApplication {

	public static void main(String[] args) {

		// Creates an Application context 'ctx', all Beans will be put in here
//		SpringApplication.run(SfgDiApplication.class, args);  Created by Spring modified by me
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		//============================================================================================================
		// The Bean name should be the same as the controller name but start with a lowercase letter making it
		// the same as the object class instance automatically created by Spring at Runtime for MyController.
		MyController myController = (MyController) ctx.getBean ("myController");
		// The method is run within the ctx Application Context, it will display 'Hello World!!!', return 'Hi Folks!'
		// String greeting = myController.sayHello (); Removed this when we modified the MyController class
		//	Outputs the return value from the method above 'Hi Folks!'

		System.out.println ("------ Primary Bean");
		System.out.println (myController.sayHello ());

		//============================================================================================================
		// Testing The Property, Setter and Constructor InjectedControllers using Spring Framework DI

		System.out.println ("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController)
				ctx.getBean ("propertyInjectedController");
		System.out.println (propertyInjectedController.getGreeting ());

		System.out.println ("------ Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController)
				ctx.getBean ("setterInjectedController");
		System.out.println (setterInjectedController.getGreeting ());

		System.out.println ("------ Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)
				ctx.getBean ("constructorInjectedController");
		System.out.println (constructorInjectedController.getGreeting ());

		// We now have four Spring Beans in the ApplicationContext 'ctx'
		// You can have two ApplicationContext in an application.

		//============================================================================================================
		// Testing Internationalization profiles, this adds an additional Bean to the context.

		System.out.println ("------ Language Profiles");
		I18nController i18nController = (I18nController)
				ctx.getBean ("i18nController");
		System.out.println (i18nController.sayHello ());

		System.out.println ("------ The Best Pet Is");
		PetController petController = (PetController)
				ctx.getBean ("petController");
		System.out.println (petController.whichPetIsTheBest ());
	}

}
