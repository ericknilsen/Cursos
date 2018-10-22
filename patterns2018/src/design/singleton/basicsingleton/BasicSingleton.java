package design.singleton.basicsingleton;

import java.io.*;

class Singleton implements Serializable {
	// cannot new this class, however
	// * instance can be created deliberately (reflection)
	// * instance can be created accidentally (serialization)
	private Singleton() {
		System.out.println("Singleton is initializing");
	}

	private static final Singleton INSTANCE = new Singleton();

	private int value = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// required for correct serialization
	// readResolve is used for _replacing_ the object read from the stream

	// protected Object readResolve()
	// {
	// return INSTANCE;
	// }

	// generated getter
	public static Singleton getInstance() {
		return INSTANCE;
	}
}

class BasicSingleton {
	static void saveToFile(Singleton singleton, String filename)
			throws Exception {
		try (FileOutputStream fileOut = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(singleton);
		}
	}

	static Singleton readFromFile(String filename) throws Exception {
		try (FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			return (Singleton) in.readObject();
		}
	}

	public static void main(String[] args) throws Exception {
		Singleton singleton = Singleton.getInstance();
		singleton.setValue(111);

		String filename = "singleton.bin";
		saveToFile(singleton, filename);

		singleton.setValue(222);

		Singleton singleton2 = readFromFile(filename);

		System.out.println(singleton == singleton2);

		System.out.println(singleton.getValue());
		System.out.println(singleton2.getValue());
	}
}
