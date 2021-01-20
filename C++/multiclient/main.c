#define _WIN32_WINNT  0x501


#undef UNICODE

#define WIN32_LEAN_AND_MEAN

#include <windows.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <stdlib.h>
#include <stdio.h>
#include <w32api.h>
// Need to link with Ws2_32.lib
#pragma comment (lib, "Ws2_32.lib")
// #pragma comment (lib, "Mswsock.lib")
#define DEFAULT_BUFLEN 512
#define DEFAULT_PORT "27015"
void DoMyStuff(char *resbuff);


int __cdecl main(int argc, char **argv)
{
    WSADATA wsaData;
    int iResult;

    SOCKET ListenSocket = INVALID_SOCKET;
    SOCKET ClientSocket = INVALID_SOCKET;

    struct addrinfo *result = NULL,
                    *ptr = NULL,
                    hints;
char *sendbuf = malloc(1024);
    SOCKET ConnectSocket = INVALID_SOCKET;
    sendbuf = "ATSIUSKVARDA\n";

    int iSendResult;
    char recvbuf[DEFAULT_BUFLEN];
    int recvbuflen = DEFAULT_BUFLEN;
  /// starting server !!
    // Initialize Winsock
    iResult = WSAStartup(MAKEWORD(2,2), &wsaData);
    if (iResult != 0) {
        printf("WSAStartup failed with error: %d\n", iResult);
        return 1;
    }

    ZeroMemory(&hints, sizeof(hints));
    hints.ai_family = AF_UNSPEC;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_protocol = IPPROTO_TCP;
    hints.ai_flags = AI_PASSIVE;

    // Resolve the server address and port
    iResult = getaddrinfo(argv[1], argv[2], &hints, &result);
    if ( iResult != 0 ) {
        printf("getaddrinfo failed with error: %d\n", iResult);
        printf("%s   \n %s", argv[1], argv[2]);
        WSACleanup();
        return 1;
    }

    // Create a SOCKET for connecting to server
    ListenSocket = socket(result->ai_family, result->ai_socktype, result->ai_protocol);
    if (ListenSocket == INVALID_SOCKET) {
        printf("socket failed with error: %ld\n", WSAGetLastError());
        freeaddrinfo(result);
        WSACleanup();
        return 1;
    }

    // Setup the TCP listening socket
    iResult = bind( ListenSocket, result->ai_addr, (int)result->ai_addrlen);
    if (iResult == SOCKET_ERROR) {
        printf("bind failed with error: %d\n", WSAGetLastError());
        freeaddrinfo(result);
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    freeaddrinfo(result);
    iResult = listen(ListenSocket, SOMAXCONN);
    if (iResult == SOCKET_ERROR) {
        printf("listen failed with error: %d\n", WSAGetLastError());
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    /// here we are accepting sockets so we need too loop this so  we accept all the time
    // Accept a client socket


    ClientSocket = accept(ListenSocket, NULL, NULL);
    if (ClientSocket == INVALID_SOCKET) {
        printf("accept failed with error: %d\n", WSAGetLastError());
        return 1;
    }


               /// after we accept socket we need to keep
    // Receive until the peer shuts down the connection
    do{
            // issiunciam pranesima
    iResult = send( ClientSocket, sendbuf, (int)strlen(sendbuf), 0 );
    if (iResult == SOCKET_ERROR) {
        printf("send failed with error: %d\n", WSAGetLastError());
        return 1;
    }
    else
    {
        printf("send bytes : %d\n", iResult);
        printf("issiuntimas pavyko ! issiusta zinute : \n ");
         printf("%s\n", sendbuf);
    }
 // chebrantas gauna pranesima ir tada bliat supistu
 // stebuklingu budu musu recv neveikia! kartoju neveikia! bbz kodel

        iResult = recv(ClientSocket, recvbuf, recvbuflen, 0);
        if (iResult > 0) {
                sendbuf[iResult] = 0;
                printf("%s\n", recvbuf);
            printf("Bytes received: %d\n", iResult);

        }
        else if (iResult == 0)
            printf("Connection closing...\n");
        else  {
            printf("recv failed with error: %d\n", WSAGetLastError());
        }
            printf(" nepavyko gaut zinutes %s\n", recvbuf);
// tarkim mes gausime ta supista varda jo .



// tada mums reikia patvirtinti jo varda, tada ziurim kas negerai




// tada mes uzregistuorajm ji ir siunciam i pokalbius ....
    }while(1);


  ////////////  // shutdown the connection since we're done  we will have to do this code in the end
  /*
    iResult = shutdown(ClientSocket, SD_SEND);
    if (iResult == SOCKET_ERROR) {
        printf("shutdown failed with error: %d\n", WSAGetLastError());
        closesocket(ClientSocket);
        WSACleanup();
        return 1;
    }
    */

    closesocket(ConnectSocket);
    WSACleanup();
}
