
public class test{
	public static void main(String args[]) {
		String[] clientList = new String[]{"cipherBlockChain","blockCipher","polyalphabeticCipher","substitutionCipher","shiftCipher"};
		String[] methodList = new String[]{ "polyalphabeticCipher","substitutionCipher","shiftCipher"};
		outerloop:
		try {
		for(int clientAlgorithm = 0; clientAlgorithm < clientList.length; clientAlgorithm++) {
			for(int serverAlgorithm =0; serverAlgorithm < methodList.length; serverAlgorithm++) {
				if(clientList[clientAlgorithm] == methodList[serverAlgorithm]) 
					{
						System.out.println("Algorithm: " + methodList[serverAlgorithm]);
						break outerloop;
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("No matching algorithms");
		}
		
	}
}