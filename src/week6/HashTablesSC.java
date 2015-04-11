package week6;

public class HashTablesSC {

	class Node{
		private String key;
		private Integer value;
		private Node next;

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
		Node temp = hashArray[i];
		Node init = hashArray[i];
		Node last= null;
		if(temp==null){
			init = new Node(key, value);
		}else{
			while(temp!=null){
				if(temp.key.equals(temp.key)){
					temp.value = value;
					return;
				}else{
					last = temp;
					temp = temp.next;
				}
			}
			if(last!=null){
				Node x = new Node(key, value);
				last.next = x;
			}
		}

		hashArray[i] = init;
	}

	public Integer get(String key){
		int i = hash(key);
		Node temp = hashArray[i];
		if(temp==null){
			return null;
		}
		while(temp!=null){
			if(temp.key.equals(temp.key)){
				return (Integer) temp.value;
			}else{
				temp = temp.next;
			}
		}
		return null;
	}


	private int hash(String key){
		return (key.hashCode() & 0x7fffffff) %size;
	}

}
