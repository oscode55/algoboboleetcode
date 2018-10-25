package leetcode.ex771numjewelsinstones;

/**
 * 字符串J代表宝石,A-Za-z有52种类且不重复,最多可以有50个
 * 字符串S代表石头,A-Za-z对应宝石种类 但可以重复,最多有50个
 * time: O( 2N )
 * space: O( N )
 */
public class NumOfJewelsYouhave {
    public static int numJewelsInStones(String J, String S) {
        boolean[] jwelsTable = new boolean[128];
        int nj = J.length();
        int ns = S.length();
        int nums = 0;
        for(int i=0;i<nj;i++){
            char currentChar = J.charAt(i);
            jwelsTable[currentChar] = true;
        }
        for(int j=0;j<ns;j++){
            char currentChar = S.charAt(j);
            if(jwelsTable[currentChar]){
                nums++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println( numJewelsInStones("aZxe","abacxc") );
    }
}
