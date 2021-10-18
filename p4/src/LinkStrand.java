public class LinkStrand implements IDnaStrand
{
    private class Node{
        String info;
        Node next;
        public Node(String s)
        {
            info = s;
            next = null;
        }
    }
    private Node myFirst,myLast;
    private long mySize;
    private int myAppends;

    private Node myCurrent;
    private int myIndex;
    private int myLocalIndex;

    /**
     * Constructor for LinkStrand with initalized empty string
     */
    public LinkStrand() { this(""); }

    /**
     * Constructor for LinkStrand but with initialized string
     * @param s string that starts linkstrand
     */
    public LinkStrand(String s) { initialize(s); }

    /**
     * returns the size of the strand
     * @return the size of the strand
     */
    @Override
    public long size() {
        return mySize;
    }

    /**
     * Prepares a string for transmission/use
     * @param source original string needs to be transformed
     */
    @Override
    public void initialize(String source) {
        myFirst = new Node(source);
        myLast = myFirst;
        mySize = source.length();
        myAppends = 0;

        myCurrent = myFirst;
        myIndex = 0;
        myLocalIndex = 0;
    }

    /** Creates new linkstrand
     * @param source is data from which object constructed
     * @return a new linkstrand that has been initialized with source
     */
    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    /**
     * Adds a dna string onto the LinkStrand
     * @param dna the string that will be added
     * @return the new IDnaStrand (with the addition)
     */
    @Override
    public IDnaStrand append(String dna) {
        Node temp = myLast;
        temp.next = new Node(dna);
        myLast = temp.next;
        mySize += dna.length();
        myAppends++;
        return this;
    }

    /**
     * Uses stringbuilder for conversion to string from linkstrand
     * @return the linkstrand converted to a string
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("");
        Node temp = myFirst;
        while(temp != null) //check this later
        {
            str.append(temp.info);
            temp = temp.next;
        }
        return str.toString();
    }

    /**
     * Reverses the order of nodes and the strings inside the nodes
     * @return a reversed IDnaStrand
     */
    @Override
    public IDnaStrand reverse() {

        Node current = myFirst;
        Node prev = null;
        Node copy = null;

        while(current != null){
            copy = new Node(new StringBuilder(current.info).reverse().toString());
            copy.next = prev;
            prev = copy;
            current = current.next;
        }

        IDnaStrand newstrand = new LinkStrand(copy.info);
        Node pointer = copy.next;

        while(pointer != null){
            newstrand.append(pointer.info);
            pointer = pointer.next;
        }

        return newstrand;
    }

    /**
     * Number of appends that have occurred
     * @return the number of stored appends that have taken place
     */
    @Override
    public int getAppendCount() {
        return myAppends;
    }

    /**
     * finds the specific character that is at a certain index
     * @param index specifies which character will be returned
     * @return the position of the character
     */
    @Override
    public char charAt(int index) {
        if(index > (mySize - 1) || index < 0)
            throw new IndexOutOfBoundsException();
        if(index > myIndex) {
            int dif = index - myIndex;
            myLocalIndex = myLocalIndex + dif;
            while (myLocalIndex >= myCurrent.info.length()) {
                myLocalIndex = myLocalIndex - myCurrent.info.length();
                myCurrent = myCurrent.next;
            }
            myIndex = index;
            return myCurrent.info.toCharArray()[myLocalIndex];
        }
        else
        {
            if(index < myIndex) {
                myCurrent = myFirst;
                myIndex = 0;
                myLocalIndex = 0;

                int dif = index - myIndex;
                myLocalIndex = myLocalIndex + dif;
                while (myLocalIndex >= myCurrent.info.length()) {
                    myLocalIndex = myLocalIndex - myCurrent.info.length();
                    myCurrent = myCurrent.next;
                }
                myIndex = index;
                return myCurrent.info.toCharArray()[myLocalIndex];
            }
            else
                return myCurrent.info.toCharArray()[myLocalIndex];
        }
    }
}
