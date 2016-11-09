package test01;

public class test01 {

	public static void main(String[] args) {
		int all=0;
		char[] sb={'0','1','2','3','4','5','6','7','8','9'};
		String s="45";
		char[] p=s.toCharArray();
		for(int i=0;i<p.length;i++){
			
			for(int j=0;j<sb.length;j++){
				if(p[i]==sb[j]){
					all=(int) (all+j*(Math.pow(10,p.length-i-1)));
				}
			}
		}
		System.out.println(all);
	}

}
