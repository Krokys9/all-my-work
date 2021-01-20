#include <iostream>

using namespace std;

int main()
{
    string input;
    getline(std::cin, input);
    cout << endl;
    char matrica [5][6] = { {'a','b','c','d','e','f'},
                            {'g','h','i','j','k','l'},
                            {'m','n','o','p','q','r'},
                            {'s','t','u','v','w','x'},
                            {'y','z',0x20,'2','3','4'}};


                for (int g = 0 ; g < input.size(); g++)
                            {
                                for (int j = 0 ; j < 6; j++)
                                {
                                    for (int i = 0 ; i < 5 ; i ++)
                                    {
                                         if (input[g] == matrica[i][j])

                                        cout << hex << i*10+ j << " ";
                                    }
                                }
                            }


                            for (int g = 0 ; g < input.size(); g++)
                            {
                                for (int j = 0 ; j < 6; j++)
                                {
                                    for (int i = 0 ; i < 5 ; i ++)
                                    {
                                         if (input[g] == matrica[i][j] && input[g] == 0x20)

                                        cout << matrica[input[g]][input[g+1]];
                                        g++;
                                    }
                                }
                            }

    return 0;
}
