package RocketLanding;

import apcs.*;

public class Rocket {

	static int x;
	static int y;
	static int dx = 5;
	static int dy;
	
	static int landx;
	
	static int level = 20;
	
	static String levelprint = "Level: " + level;
	
	static String message = "Land the rocket on the blue landing pad.";
	
	
	public static void main(String[] args) {
		
		Window.size(1000, 1000);
		landx = Window.rollDice(Window.width());
		
		while(true){
			Window.frame();
			
			Window.out.background("green");
			
			Window.out.color("white");
			Window.out.print(message, 100, 100);
			Window.out.print(levelprint, 100, 120);
			
			
			draw();
			move();
			IfOnGround();
		}
	}
	
	public static void draw()
	{
		
		Window.out.color("grey");
		Window.out.rectangle(x, y, 50, 70);
		
		if(Window.key.pressed("w"))
		{
			Window.out.color("orange");
			Window.out.polygon(x - 25, y + 35, x + 25, y + 35, x, (int) (y + 35 + 25*Math.sqrt(3)));
		}
		
		Window.out.color("blue");
		Window.out.rectangle(landx, Window.height(), 100, 10);
	}
	
	public static void move()
	{
		y += dy;
		dy += 1;
		
		if(Window.key.pressed("w"))
		{
			dy -= 2;
		}
		
		if(Window.key.pressed("a"))
		{
			x -= dx;
		}
		
		if(Window.key.pressed("d"))
		{
			x += dx;
		}
	}
	
	public static void IfOnGround()
	{
		// If the rocket is on the ground
		if (y >= Window.height() - 30)
		{
			// If it is on the landing pad
			if (Math.abs(x - landx) <= 50 && dy <= level)
			{
				x = 0;
				y = 0;
				dy = 0;
				message = "Nice! You won!";
				landx = Window.rollDice(Window.width());
				level--;
			}
			// If it isn't on the pad
			else
			{
				x = Window.width();
				y = 0;
				dy = 0;
				message = "Oh noes! You have utterly obliterated your rocket! But don't worry...";
				landx = Window.rollDice(Window.width());
			}
		}
	}

}
