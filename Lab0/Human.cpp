#include <string>

using namespace std;

class Human{
	private: int age;
	public:
		void setAge( int age){
			this->age = age;
		}
		int getAge(){
			return this->age;
		}
};
