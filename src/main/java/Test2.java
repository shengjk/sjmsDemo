/**
 * @author shengjk1
 * @date 2020/9/22
 */
public class Test2 {
	int a;
	volatile int v1 = 1;
	volatile int v2 = 2;

	public static int murmurHash(int code) {
		code *= 0xcc9e2d51;
		code = Integer.rotateLeft(code, 15);
		code *= 0x1b873593;

		code = Integer.rotateLeft(code, 13);
		code = code * 5 + 0xe6546b64;

		code ^= 4;
		code = bitMix(code);

		if (code >= 0) {
			return code;
		} else if (code != Integer.MIN_VALUE) {
			return -code;
		} else {
			return 0;
		}
	}

	public static int bitMix(int in) {
		in ^= in >>> 16;
		in *= 0x85ebca6b;
		in ^= in >>> 13;
		in *= 0xc2b2ae35;
		in ^= in >>> 16;
		return in;
	}

	//68075478
	public static void main(String[] args) {
		System.out.println(murmurHash(2));

		System.out.println(String.valueOf(Integer.MAX_VALUE).length());
		System.out.println(Integer.MAX_VALUE);
	}

	void readAndWrite() {
		int i = v1;
		int j = v2;
		a = i + j;
		v1 = i + 1;
		v2 = j * 2;
	}
}
