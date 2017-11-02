#include <iostream>
using namespace std;
int main() {
	int data[10], c1, c2, c3;
	int data_rec[10];
	cin >> data[0];
	cin >> data[1];
	cin >> data[2];
	cin >> data[4];
	data[6] = data[0] ^ data[2] ^ data[4];
	data[5] = data[0] ^ data[1] ^ data[4];
	data[3] = data[0] ^ data[1] ^ data[2];
	cout << "Encoded data:" << endl;
	for(int i = 0; i < 7; i++)
		cout << data[i];
	cout << endl;
	for(int i = 0; i < 7; i++)
		cin >> data_rec[i];
	c1 = data_rec[6] ^ data_rec[0] ^ data_rec[2] ^ data_rec[4];
	c2 = data_rec[5] ^ data_rec[0] ^ data_rec[1] ^ data_rec[4];
	c3 = data_rec[3] ^ data_rec[0] ^ data_rec[1] ^ data_rec[2];
	int c = c3*4+c2*2+c1;
	if(c == 0) {
		cout << "No error" << endl;
	} else {
		if(data_rec[7-c] == 0)
			data_rec[7-c] = 1;
		else
			data_rec[7-c] = 0;
		for(int i = 0; i < 7; i++)
			cout << data_rec[i];
	}
	return 0;
}
