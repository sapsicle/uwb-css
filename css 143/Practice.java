public class Practice {
    public boolean findIt(String base, String findMe) {
        if (base.equals(findMe)) return true;
        else if (base.substring(0, findMe.length()).equals(findMe)) return true;
        else return findIt(base.substring(1), findMe);
    }
}
