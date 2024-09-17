package com.gooot;

public class Costomer {


	public void order(String menuName , Menu menu , Cooking cooking){

		MenuItem menuItem = menu.choose(menuName);
		cooking.makeCook(menuItem);
	}

}
