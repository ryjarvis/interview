package arrays;

/**
 * @author: ryjarvis Apr 2, 2018
 * 
 */
// LeetCode #717
public class OneBitAndTwoBitCharacters {

	public boolean isOneBitCharacter(int[] bits) {
		if (bits.length == 1) {
			return true;
		}
		if (bits[bits.length - 2] == 0) {
			return true;
		}
		if (bits.length > 2 && bits[bits.length - 2] == 1 && bits[bits.length - 3] == 0) {
			return false;
		} else {
			return decodable(bits, bits.length - 2);
		}

	}

	public boolean decodable(int[] bits, int i) {
		if (i == 0)
			return bits[i] == 0;
		if (i == 1)
			return !(bits[1] == 1 && bits[0] == 0);
		else {
			if (bits[i] == 0) {
				if (bits[i - 1] == 0) {
					return decodable(bits, i - 1);
				} else {
					return (decodable(bits, i - 1) || decodable(bits, i - 2));
				}
			} else {
				if (bits[i - 1] == 1) {
					return decodable(bits, i - 2);
				} else {
					return false;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
