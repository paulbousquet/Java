import static java.lang.StrictMath.sqrt;

/**
 * Celestial Body class for NBody
 * @author ola
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
						 double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel= yv;
		myMass = mass;
		myFileName= filename;
	}
	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		this.myXPos = b.myXPos;
		this.myYPos = b.myYPos;
		this.myXVel = b.myXVel;
		this.myYVel = b.myYVel;
		this.myMass = b.myMass;
		this.myFileName = b.myFileName;
	}

	public double getX() {
		return myXPos;
	}
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		return sqrt((this.myXPos-b.myXPos)*(this.myXPos-b.myXPos)+(this.myYPos-b.myYPos)*(this.myYPos-b.myYPos));
	}

	public double calcForceExertedBy(CelestialBody b) {
		double gg = 6.67e-11;
		double stor = (gg*this.myMass*b.myMass)/(calcDistance(b)*calcDistance(b));
		return stor;
	}

	public double calcForceExertedByX(CelestialBody b) {
		double stor = (calcForceExertedBy(b)*(-this.myXPos+b.myXPos))/calcDistance(b);
		return stor;
	}
	public double calcForceExertedByY(CelestialBody b) {
		double stor = (calcForceExertedBy(b)*(-this.myYPos+b.myYPos))/calcDistance(b);
		return stor;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double sum=0;
		for (CelestialBody c:bodies){
			if(!c.equals(this)){
				sum = sum + (calcForceExertedBy(c)*(-this.myXPos+c.myXPos))/calcDistance(c);
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for (CelestialBody c:bodies){
			if(!c.equals(this)){
				sum = sum + (calcForceExertedBy(c)*(-this.myYPos+c.myYPos))/calcDistance(c);
			}
		}
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		double ax = xforce/myMass;
		double ay = yforce/myMass;
		double nrx = myXVel + deltaT*ax;
		double nry = myYVel + deltaT*ay;
		double nx = myXPos+deltaT*nrx;
		double ny = myYPos+deltaT*nry;
		myXPos = nx;
		myYPos = ny;
		myXVel = nrx;
		myYVel = nry;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}

}
