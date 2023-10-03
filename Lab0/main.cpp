#include <iostream>
#include "Human.cpp"
#include "User.cpp"
int main(int argc, char** argv) {
	Human human;
	human.setAge(19);
	cout << human.getAge() << "\n"; 
	system("pause");
	return 0;
}
