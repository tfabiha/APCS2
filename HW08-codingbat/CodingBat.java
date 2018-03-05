public class CodingBat {    

    public static String strDist(String str, String sub) {
	if (str.length() < sub.length()) {
	    return str;
	    //return 0;
	}
  
	if (str.substring(0,sub.length()).equals(sub) && str.substring(str.length()-sub.length()).equals(sub)) {
	    return str;
	    //return str.length();
	}
  
	if (!(str.substring(0,sub.length()).equals(sub))) {
	    return strDist(str.substring(1), sub);
	} else {
	    return strDist(str.substring(0,str.length()-1), sub);
	}
    }


    public static void main(String[] args) {
	System.out.println(strDist("catcowcat", "cat")) ;// 9	9	OK	
	System.out.println(strDist("catcowcat", "cow")) ;// 3	3	OK	
	System.out.println(strDist("cccatcowcatxx", "cat")) ;// 9	0	X	
	System.out.println(strDist("abccatcowcatcatxyz", "cat")) ;// 12	12	OK	
	System.out.println(strDist("xyx", "x")) ;// 3	3	OK	
	System.out.println(strDist("xyx", "y")) ;// 1	1	OK	
	System.out.println(strDist("xyx", "z")) ;// 0	0	OK	
	System.out.println(strDist("z", "z")) ;// 1	1	OK	
	System.out.println(strDist("x", "z")) ;// 0	0	OK	
	System.out.println(strDist("", "z")) ;// 0	0	OK	
	System.out.println(strDist("hiHellohihihi", "hi")) ;// 13	13	OK	
	System.out.println(strDist("hiHellohihihi", "hih")) ;// 5	3	X	
	System.out.println(strDist("hiHellohihihi", "o")) ;// 1	1	OK	
	System.out.println(strDist("hiHellohihihi", "ll")) ;// 2	0	X
    }
}
