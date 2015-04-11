package week6;

public class HashTablesLP {

	class Node{
		private String key;
		private Integer value;

		Node(String k, Integer v){
			this.key =  k;
			this.value = v;
		}
	}

	private int size = 50;
	private Node[] hashArray = new Node[size];



	public void put(String key, Integer value){
		System.out.print("Try to add " + key + " : " + value);
		int i = hash(key);
		System.out.println(" & Hash value is " + i);
		Node temp = new Node(key, value);
		if(hashArray[i] == null){
			hashArray[i] = temp;
		}else{
			while(hashArray[i]!=null){
				i++;
			}
			hashArray[i] = temp;
		}

	}

	public Integer get(String key){
		int i = hash(key);
		while(hashArray[i]!=null){
			if(hashArray[i].key.equals(key)){
				return hashArray[i].value;
			}
			i++;
		}
		return null;
	}


	private int hash(String key){
		return (key.hashCode() & 0x7fffffff) %size;
	}

}
