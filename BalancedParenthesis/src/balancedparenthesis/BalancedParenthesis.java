package balancedparenthesis;
import java.util.Scanner;
import java.util.Stack;
public class BalancedParenthesis {
    
    public static boolean checkBalanced(String exp){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '['){
                st.push(exp.charAt(i));
            }
            else if(exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']'){
                if(st.isEmpty()){
                    return false;
                }
                char ch = st.pop();
                if(exp.charAt(i)==')' && ch == '('){
                    continue;
                }
                else if(exp.charAt(i)=='}' && ch == '{'){
                    continue;
                }
                else if(exp.charAt(i)==']' && ch == '['){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        else{
            return false;
        }
        
    }
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        String input = s.nextLine();
        System.out.println(checkBalanced(input));
    }
    
}
