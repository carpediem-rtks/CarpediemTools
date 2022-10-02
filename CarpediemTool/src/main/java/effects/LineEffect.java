package effects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

public class LineEffect {
	
	private Location start,goal;
	private List<Particle> particles = new ArrayList<Particle>();
	private int particleAmount;
	private double diffX,diffY,diffZ;
	private double speed;
	
	public LineEffect(Location start,Location goal,int particleAmount,double x,double y,double z,double speed,Particle... particle) {
		this.start = start;
		this.goal = goal;
		this.particleAmount = particleAmount;
		diffX = x;
		diffY = y;
		diffZ = z;
		for(Particle p : particle) {
			particles.add(p);
		}
	}
	
	public void play() {
		Location loc2= start.clone();
		Location l= start.clone();
		Location loc= goal.clone();
		int _distance=(int) loc.distance(loc2)*20;
		loc.subtract(loc2.getX(), loc2.getY(), loc2.getZ());
		double d=1D/_distance;
		double x=loc.getX()*d;
		double y=loc.getY()*d;
		double z=loc.getZ()*d;
		for(int i=0;i<_distance;i++){
			Location spawn = new Vector(l.getX()+x*i, l.getY()+y*i,l.getZ()+z*i).toLocation(start.getWorld());
			for(Particle p: particles) {
				spawn.getWorld().spawnParticle(p,spawn,particleAmount,diffX,diffY,diffZ,speed);
			}
		}
	}
}
