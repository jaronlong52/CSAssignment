public class Driver {
    public static void main(String[] args)
	{
		char[] array1 = {'a', 'b', 'c', 'd', };
        char[] array2 = {'a', 'b', 'c', 'b', };
        char[] array3 = {'A', 'B', 'C', 'D', };
		CharacterArray ca1 = new CharacterArray(array1);
		CharacterArray ca2 = ca1.replace('b', 'd');
        CharacterArray ca3 = new CharacterArray(array2);
        CharacterArray ca4 = ca1.clone();
        System.out.println(ca1);
        System.out.println(ca2);

        // test .length() on CharacterArray
        System.out.println("Test .length()");
        System.out.println("Should be = 4");
        System.out.println(ca1.length());

        // test compareTo
        System.out.println("Test .compareTo");
        System.out.println(ca1.compareTo(ca2)); // should be = -2
        System.out.println(ca1.compareTo(ca3)); // should be = 2
        System.out.println(ca1.compareTo(ca4)); // should be = 0

        // test .toLowerCase()
        System.out.println("upper to lower");
        CharacterArray upper1 = new CharacterArray(array3);
        System.out.println(upper1);
        upper1 = upper1.toLowerCase();
        System.out.println(upper1);

        // test .toUpperCase()
        System.out.println("lower to upper");
        System.out.println(upper1);
        upper1 = upper1.toUpperCase();
        System.out.println(upper1);

        // test .compareToIgnoreCase()
        System.out.println("compare to ignore case");
        System.out.println(upper1.compareTo(ca1)); // should be different due to case sensitivity
        System.out.println(upper1.compareToIgnoreCase(ca1)); // should be 0
        System.out.println(upper1); // should still be upper case as upper1 should not be changed

        // test equals()
        System.out.println("equals test");
        System.out.println("should be false: " + upper1.equals(ca1));

        // test equalsIgnoreCase()
        System.out.println("equals ignore case test");
        System.out.println("should be true: " + upper1.equalsIgnoreCase(ca1));



        // test trim
        System.out.println("trim test: |untrimmed| -- |trimmed|");
        char[] noSp = {'a', 'b', 'c', 'd', };
        CharacterArray noSpace = new CharacterArray(noSp);
        char[] lead = {' ', ' ', ' ', 'b',};
        CharacterArray leading = new CharacterArray(lead);
        char[] trail = {'a', 'b', ' ', ' ',};
        CharacterArray trailing = new CharacterArray(trail);
        char[] leadTr = {' ', ' ', 'a', 'b', ' ', ' ',};
        CharacterArray leadTrail = new CharacterArray(leadTr);
        char[] spa = {' ', ' ',' ', ' ',};
        CharacterArray space = new CharacterArray(spa);

        System.out.println("|" + noSpace + "| -- |" +  noSpace.trim() + "|");
        System.out.println("|" + leading + "| -- |" +  leading.trim() + "|");
        System.out.println("|" + trailing + "| -- |" +  trailing.trim() + "|");
        System.out.println("|" + leadTrail + "| -- |" +  leadTrail.trim() + "|");
        System.out.println("|" + space + "| -- |" +  space.trim() + "|");


        // isEmpty() test
        System.out.println("testing isEmpty()");
        System.out.println("Should be true: " + space.trim().isEmpty());
        System.out.println("Should be false: " + space.isEmpty());
	}
}
