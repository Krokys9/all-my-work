#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void saveToFile(int *mas, int sizeo, char *filename)
{
    saveCount++;
    FILE *fp = fopen(filename, "wb");
    fseek(fp, 0, SEEK_SET);
    fwrite(&sizeo, sizeof(int), 1, fp);
    fwrite(mas,sizeof(int), sizeo, fp);
    fclose(fp);
    fflush(fp);

}
int* loadFromFile (char *filename)
{
    loadCount ++;
    FILE *fp = fopen(filename, "rb");
    fseek(fp, 0, SEEK_SET);
    int size, *mas;
    fread(&size, sizeof(int), 1, fp);
    mas = malloc(sizeof(int)*(size+1));
    fread(mas, sizeof(int), size, fp);
    fclose(fp);
    fflush(fp);

    return mas;
}

void flush(int index1,int index2, int valueCard1, int valueCard2,int place);
void pairs(int card1, int card2,int place);
void straith(int card1, int card2,int place);
void bet(int *playerMoney, int bet);
void Deal();
void eiknahoi ();
void firstshow();
void river();
void show_table(place);
int straith_value = -1;
/// booliai
int flushas = 0;
int straithtas = 0;
int pouros = 0;
int two_pair = 0;
int three_pair = 0;
int four_pair = 0;
///
int pot= 0;
int max; /// skirtas tikrinimui flusho
int tikrinimui[9][2]; /// reikalingas tam kad butu lengviau tikrinti reiksmes.
void my_hand();
struct hand
{
    int firstCard;
    int secondCard;
    int indexFirstCard;
    int indexSecondCard;
};
void hand_Check(struct hand ranka, int place);
struct table_Flop
{
    int firstShow[3];
    int firstShowindex[3];
    int TurnCard;
    int TurnCardIndex;
    int River;
    int RiverIndex;
};
struct hand handofplayer;
struct hand handofcomputer;
struct table_Flop showOff;
int cards[13]= {0};
int spalvos = 4;
char H[] = "Hearths";
char S[] = "Spades";
char D[]= "Diamonds";
char C[] = "Clubs";
int main()
{
    int player_money=1000;
    int beforeflop = 1;
    int variable = -1;
    int new_game = 1;
    int allgood = 0;
    int betas = 0;
    int beforeturn = 1;
    int beforeriver = 1;
    int riveris = 1;
    int pot = 0;
    int place;
    int winner;
    srand(time(NULL));
    FILE *save = fopen("test.bin.", "wb");
    for (int i = 0; i < 9; i ++)
    {


        cards[i] = i+50;
        cards[9] = 74;
        cards[10] = 81;
        cards[11] = 75;
        cards[12] = 65;
    }
    while (1)
    {
        printf ( " new game !!!!!!!!\n\n\n\n\n\n");
        Deal();
        beforeflop = 1;
        new_game = 1;
        pot = 0;

        while(beforeflop == 1)
        {
            place = 5;
            printf("iveskite vieneta kad statytumet, iveskite 2 kad checkintumet, 3 kad ismestumet kortas, 4 kad parodytu jusu ranka\n\n");
            scanf("%d", &variable);
            printf("\n");
            if(variable == 1)
            {
                printf("kiek statote? , negalite virsiti %d\n", player_money);
                scanf("%d", &betas);
                pot += betas;
                player_money -= betas;
                allgood = 1;
            }
            else if (variable == 2)
            {
                allgood = 1;
            }
            else if(variable == 3)
            {
                new_game = 0;
                allgood = 1;
                place = 5;
            }
            else if(variable == 4)
            {
                hand_Check(handofplayer, place);
            }
            if(allgood==1)
            {
                break;
            }
        }

        firstshow();
        allgood= 0;
        beforeturn = 1;

        if(new_game == 1)
        {
            place = 2;
            while(beforeturn)
            {
                printf("pirmos trys kortos ant stalo : \n");
                show_table(2);
                printf("iveskite vieneta kad statytumet, iveskite 2 kad checkintumet, 3 kad ismestumet kortas, 4 kad parodytu jusu ranka\n\n");
                scanf("%d", &variable);
                printf("\n");
                if(variable == 1)
                {
                    printf("kiek statote? , negalite virsiti %d\n", player_money);
                    scanf("%d", &betas);
                    pot += betas;
                    player_money -= betas;
                    allgood = 1;
                }
                else if (variable == 2)
                {
                    allgood = 1;
                }
                else if(variable == 3)
                {
                    new_game = 0;
                    break;
                }
                else if(variable == 4)
                {
                    hand_Check(handofplayer, place);
                }
                if(allgood)
                {
                    beforeturn = 0;

                }
            }
        }
        turn();
        allgood = 0;
        beforeriver = 1;
        if(new_game == 1)
        {
            place = 1;
            while(beforeriver)
            {
                printf("keturios kortos ant stalo : \n");
                show_table(1);
                printf("iveskite vieneta kad statytumet, iveskite 2 kad checkintumet, 3 kad ismestumet kortas, 4 kad parodytu jusu ranka\n\n");
                scanf("%d", &variable);
                printf("\n");
                if(variable == 1)
                {
                    printf("kiek statote? , negalite virsiti %d\n", player_money);
                    scanf("%d", &betas);
                    pot += betas;
                    player_money -= betas;
                    allgood = 1;
                }
                else if (variable == 2)
                {
                    allgood = 1;
                }
                else if(variable == 3)
                {
                    new_game = 0;
                    break;
                }
                else if(variable == 4)
                {
                    hand_Check(handofplayer, place);
                }
                if(allgood)
                {
                    beforeriver = 0;

                }
            }
        }
        river();
        allgood = 0;
        riveris = 1;
        if(new_game == 1)
        {
            place = 0;
            while(riveris)
            {
                printf("penkios kortos ant stalo : \n");
                show_table(0);
                printf("iveskite vieneta kad statytumet, iveskite 2 kad checkintumet, 3 kad ismestumet kortas, 4 kad parodytu jusu ranka\n\n");
                scanf("%d", &variable);
                printf("\n");
                if(variable == 1)
                {
                    printf("kiek statote? , negalite virsiti %d\n", player_money);
                    scanf("%d", &betas);
                    pot += betas;
                    player_money -= betas;
                    allgood = 1;
                }
                else if (variable == 2)
                {
                    allgood = 1;
                }
                else if(variable == 3)
                {
                    new_game = 1;
                    break;
                }
                else if(variable == 4)
                {
                    hand_Check(handofplayer, place);
                }
                if(allgood)
                {
                    riveris = 0;

                }
            }
        }
        if(new_game ==1)
        {

        printf("kompiuterio korotos ir jis turi :\n");
        hand_Check(handofcomputer, place);
        printf("zaidejo korotos ir jis turi :\n");
        hand_Check(handofplayer, place);
        winner = wining_hand();
        if(winner == 0)
        {
            printf("laimejo kompiuteris\n");
        }
        else if(winner == 1)
        {
            printf("laimejo zmogus\n");
            player_money +=2*pot;
        }
        else
        {
            printf("lygiosios\n");
            player_money+=pot;
        }
        }
    }
    return 0;
}
void Deal()
{
    int cycle = 1;
    ///Deal starts
    tikrinimui[0][0] = handofplayer.indexFirstCard = rand()%4;
    tikrinimui[0][1] = handofplayer.firstCard = cards[rand()%13];
    while(cycle)
    {
        tikrinimui[1][0] = handofcomputer.indexFirstCard = rand()%4;
        tikrinimui[1][1] = handofcomputer.firstCard = cards[rand()%13];
        cycle = 0;
        if(handofcomputer.indexFirstCard == handofplayer.indexFirstCard  && handofcomputer.firstCard == handofplayer.firstCard)
        {
            cycle = 1;
        }

    }
    cycle = 1;
    while(cycle)
    {
        tikrinimui[2][0] =handofplayer.indexSecondCard = rand()%4;
        tikrinimui[2][1] =handofplayer.secondCard = cards[rand()%13];
        cycle = 0;
        if(handofplayer.indexSecondCard == handofplayer.indexFirstCard  && handofplayer.secondCard == handofplayer.firstCard)
        {
            cycle = 1;
        }
        else if(handofplayer.indexSecondCard == handofcomputer.indexFirstCard  && handofplayer.secondCard == handofcomputer.firstCard)
        {
            cycle = 1;
        }

    }
    cycle = 1;
    while(cycle)
    {
        tikrinimui[3][0] =handofcomputer.indexSecondCard = rand()%4;
        tikrinimui[3][1] =handofcomputer.secondCard = cards[rand()%13];
        cycle = 0;
        if(handofcomputer.indexSecondCard == handofplayer.indexFirstCard  && handofcomputer.secondCard == handofplayer.firstCard)
        {
            cycle = 1;
        }
        else if(handofcomputer.indexSecondCard == handofcomputer.indexFirstCard  && handofcomputer.secondCard == handofcomputer.firstCard)
        {
            cycle = 1;
        }
        else if(handofplayer.indexSecondCard == handofcomputer.indexSecondCard  && handofplayer.secondCard == handofcomputer.secondCard)
        {
            cycle = 1;
        }

    }
    /*   printf("%d   %c \n",handofplayer.indexFirstCard, handofplayer.firstCard);
       printf("%d   %c \n",handofplayer.indexSecondCard, handofplayer.secondCard);
       printf("%d   %c \n",handofcomputer.indexFirstCard, handofcomputer.firstCard);
       printf("%d   %c \n\n",handofcomputer.indexSecondCard, handofcomputer.secondCard);
       */
}

void firstshow()
{
    int cycle = 1;
    int a =0;
    int hey = 0;
    /// atverciamos pirmosios kortos
    while(cycle)
    {
        for(int j = 0; j < 3+hey; j++)
        {
            tikrinimui[4+j-hey][0] = showOff.firstShowindex[j-hey] = rand()%4;
            tikrinimui[4+j-hey][1] = showOff.firstShow[j-hey] = cards[rand()%13];
            cycle = 0;

            for(int i = 0; i < 3+a-hey; i++)
            {
                if (tikrinimui[i][0] == showOff.firstShowindex[j-hey] && tikrinimui[i-hey][1] == showOff.firstShow[-hey])
                {
                    cycle = 1;
                    hey++;
                }
            }
            a++;
        }
    }
}
void eiknahoi ()
{
    for (int i = 0; i < 9; i ++)
    {
        reconize_cards(tikrinimui[i][0], tikrinimui[i][1]);
    }
}
void turn()
{
    int cycle = 1;
    int hey = 0;
    while(cycle)
    {
        tikrinimui[7][0] = showOff.TurnCardIndex = rand()%4;
        tikrinimui[7][1] = showOff.TurnCard = cards[rand()%13];
        cycle = 0;

        for(int i = 0; i < 7+hey; i ++)
        {
            if (tikrinimui[i][0] == showOff.TurnCardIndex && tikrinimui[i][1] == showOff.TurnCard)
            {
                cycle = 1;
            }
        }
    }
}
void river()
{
    int cycle = 1;
    while(cycle)
    {
        tikrinimui[8][0] = showOff.RiverIndex = rand()%4;
        tikrinimui[8][1] = showOff.River = cards[rand()%13];
        cycle = 0;

        for(int i = 0; i < 8; i ++)
        {
            if (tikrinimui[i][0] == showOff.RiverIndex && tikrinimui[i][1] == showOff.River)
            {
                cycle = 1;
            }
        }
    }
}
void reconize_cards(int index, int card)
{

    if ( card !=58)
    {
        printf("%c", card);
    }
    else if( card == 58)
    {
        printf("10");
    }
    printf("   of    ");
    if(index == 0)
    {
        printf("%s", H);
    }
    else  if(index == 1)
    {
        printf("%s", S);
    }
    else if(index == 2)
    {
        printf("%s", D);
    }
    else if(index == 3)
    {
        printf("%s", C);
    }
    printf("   ");

    printf("\n\n");
}
void flush(int index1,int index2, int valueCard1, int valueCard2,int place)
{
    int flush = 0;
    int mas[5];
    int masindex = 0;

    for(int index = 0; index < spalvos; index++)
    {
        flush = 0;
        masindex = 0;
        for (int j = 0; j < 5 ; j ++)
        {
            mas[j] = -1;
        }
        if(index1 == index)
        {
            mas[masindex] = valueCard1;
            masindex++;
            flush++;

        }
        if(index2 == index)
        {
            flush++;
            mas[masindex] = valueCard2;
            masindex++;
        }
        for(int i = 4 ; i < 9-place; i ++)
        {
            if(tikrinimui[i][0] == index)
            {
                mas[masindex] = tikrinimui[i][1];
                masindex++;
                flush++;

            }
        }
        if(flush >= 5)
        {
            flushas = 1;
            if(index == 0)
            {
                printf("%s", H);
            }
            else  if(index == 1)
            {
                printf("%s", S);
            }
            else if(index == 2)
            {
                printf("%s", D);
            }
            else if(index == 3)
            {
                printf("%s", C);
            }
            printf(" flush ");
            max = mas[0];
            for(int i = 1; i < 5; i++)
            {
                if(max < mas[i])
                {
                    max = mas[i];
                }
            }
            printf("kicker card : %c", max);
        }

    }
    printf("\n");
}
void pairs(int card1, int card2,int place)
{
    int pairindex = 0;
    int pair = 0;
    int threeindex = 0;
    int fourindex = 0;
    int poru_skaicius = 0;
    int labas = 1;
    for(int i = 12 ; i >= 0; i --)
    {
        pair = 0;
        if(cards[i] == card1)
        {
            pair ++;
        }
        if(cards[i] == card2)
        {
            pair ++;
        }
        for ( int j = 4 ; j < 9-place; j++)
        {
            if(cards[i] == tikrinimui[j][1])
            {
                pair++;
            }
        }
        if(pair == 2)
        {
            if ( poru_skaicius < 2)
            {
                labas = 0;
                pairindex = i;
                printf("jus turite pora : %c \n", cards[pairindex]);
                poru_skaicius++;

            }

        }
        if(pair == 3)
        {
            labas = 0;
            threeindex = i;
            printf("jus turite tris : %c \n", cards[threeindex]);
        }
        if(pair == 4)
        {
            labas = 0;
            fourindex = i;
            printf("jus turite keturias : %c \n", cards[fourindex]);
        }

    }
    if(labas)
    {
        printf("neturite poru\n");
    }
}
void straith(int card1, int card2,int place)
{
    int straith = 0;
    int kintamasis= 0;
    int k = 4;
    int index = -1;
    for(int i = 0; i < 9; i ++)
    {
        straith = 0;
        for( int g = 0 ; g < 5; g++)
        {
            k = 4;
            if(cards[i+g] == card1  || cards[i+g] == card2)
            {
                straith++;
                k = 9;
            }
            for(int  j = k ; j < 9-place; j++)
            {

                if( cards[i+g] == tikrinimui[j][1])
                {
                    straith++;
                    break;
                }
            }
            if(straith == 5)
            {
                index = i+4;
            }
        }
    }
    if(index == -1)
    {
        printf("eiles nera\n");
    }
    else
    {
        printf("just turite eile : ");
        for(int i = index-4; i < index+1; i++)
        {
            straith_value = index;
            printf("%c ,", cards[i]);
        }
    }
}
void hand_Check(struct hand ranka, int place)
{
    my_hand(ranka);
    flush(ranka.indexFirstCard, ranka.indexSecondCard, ranka.firstCard, ranka.secondCard,place);
    straith(ranka.firstCard, ranka.secondCard,place);
    pairs(ranka.firstCard, ranka.secondCard,place);

}
void my_hand(struct hand ranka)
{
    reconize_cards(ranka.indexFirstCard, ranka.firstCard);
    reconize_cards(ranka.indexSecondCard, ranka.secondCard);
}
void show_table(place)
{
    for(int i = 4; i < 9-place; i ++)
    {
        reconize_cards(tikrinimui[i][0],tikrinimui[i][1]);
    }
}
int wining_hand(struct hand handofplayer, struct hand handofcomputer)
{
    int win_cof_human=-1;
    int win_cof_computer=-1;
    int winner=0;
    for(int i = 0; i < 13; i ++)
    {
        if(handofplayer.firstCard == cards[i]) /// high card zomgaus
        {
            win_cof_human = i;
        }
        if(handofcomputer.firstCard == cards[i])/// high card kompo
        {
            win_cof_computer = i;
        }
        if(handofplayer.secondCard == cards[i])/// high card zzmogaus
        {
            win_cof_human = i;
        }
                if(handofcomputer.secondCard == cards[i])/// high card kompo
        {
            win_cof_computer = i;
        }
    }
    int pair = 0;
    int m = 0;
    int poru_skaiciush = 0;
    int poru_skaiciuscp = 0;
    int daugiau_uz_eile = 1;
    for(int i = 12 ; i >= 0; i --)
    {
        pair = 0;
        m = 0;
        if(cards[i] == handofplayer.firstCard)
        {
            pair ++;
        }
        if(cards[i] == handofplayer.secondCard) /// tikrina poras tam tikrojoe vietoje /// zmogus
        {
            pair ++;
        }
        for ( int j = 4 ; j < 9; j++)
        {
            if(cards[i] == tikrinimui[j][1])
            {
                pair++;
            }
        }
        if(pair == 2)
        {
            if ( poru_skaiciush == 0)
            {
                win_cof_human = 13+i;
                poru_skaiciush++;

            }
            else if( poru_skaiciush == 1)
            {
                win_cof_human = 26 + i;
                poru_skaiciush++;

            }

        }
        if(pair == 3)
        {
            win_cof_human = 40+i;
        }
        if(pair == 4)
        {
            win_cof_human=73 + i;
            daugiau_uz_eile = 0;
        }

        pair = 0;
        if(cards[i] == handofcomputer.firstCard)
        {
            pair ++;
        }
        if(cards[i] == handofcomputer.secondCard)
        {
            pair ++;
        }
        for ( int j = 4 ; j < 9; j++)
        {
            if(cards[i] == tikrinimui[j][1])
            {
                pair++;
            }
        }
        if(pair == 2)
        {
            if (poru_skaiciuscp == 0)
            {
                win_cof_computer = 13+i;
                poru_skaiciuscp++;

            }
            else if (poru_skaiciuscp == 1)
            {
                win_cof_computer = 26 + i;
                poru_skaiciuscp++;

            }

        }
        if(pair == 3)
        {
            win_cof_computer = 40+i;
        }
        if(pair == 4)
        {
            win_cof_computer=73 + i;
            daugiau_uz_eile = 0;
        }

    }
    if(daugiau_uz_eile == 1)
    {
        int straith = 0;
        int k = 4;
        for(int i = 0; i < 9; i ++)
        {
            straith = 0;
            for( int g = 0 ; g < 5; g++)
            {
                k = 4;
                if(cards[i+g] == handofplayer.firstCard  || cards[i+g] == handofplayer.secondCard)
                {
                    straith++;
                    k = 9;
                }
                for(int  j = k ; j < 9; j++)
                {

                    if( cards[i+g] == tikrinimui[j][1])
                    {
                        straith++;
                        break;
                    }
                }
                if(straith == 5)
                {
                    win_cof_human = 61+i;
                }
            }
                straith = 0;
            for( int g = 0 ; g < 5; g++)
            {
                k = 4;
                if(cards[i+g] == handofcomputer.firstCard  || cards[i+g] == handofcomputer.secondCard)
                {
                    straith++;
                    k = 9;
                }
                for(int  j = k ; j < 9; j++)
                {

                    if( cards[i+g] == tikrinimui[j][1])
                    {
                        straith++;
                        break;
                    }
                }
                if(straith == 5)
                {
                    win_cof_computer = 61+i;
                }
            }
        }
    }
    int flush = 0;
    int mas[5];
    int masindex = 0;
    for(int index = 0; index < spalvos; index++)
    {
        flush = 0;
        masindex = 0;
        for (int j = 0; j < 5 ; j ++)
        {
            mas[j] = -1;
        }
        if(handofplayer.indexFirstCard == index)
        {
            mas[masindex] = handofplayer.firstCard;
            masindex++;
            flush++;

        }
        if(handofplayer.indexSecondCard == index)
        {
            flush++;
            mas[masindex] = handofplayer.secondCard;
            masindex++;
        }
        for(int i = 4 ; i < 9; i ++)
        {
            if(tikrinimui[i][0] == index)
            {
                mas[masindex] = tikrinimui[i][1];
                masindex++;
                flush++;

            }
        }
        if(flush >= 5)
        {
            max = mas[0];
            for(int i = 1; i < 5; i++)
            {
                if(max < mas[i])
                {
                    for(int j =0; j < 13; j++)
                    {
                        if(cards[i]== max)
                        {
                            max = mas[i];
                            win_cof_human = 75+max;
                        }
                    }
                }

            }

        }
        flush = 0;
        masindex = 0;
        for (int j = 0; j < 5 ; j ++)
        {
            mas[j] = -1;
        }
        if(handofcomputer.indexFirstCard == index)
        {
            mas[masindex] = handofcomputer.firstCard;
            masindex++;
            flush++;

        }
        if(handofcomputer.indexSecondCard == index)
        {
            flush++;
            mas[masindex] = handofcomputer.secondCard;
            masindex++;
        }
        for(int i = 4 ; i < 9; i ++)
        {
            if(tikrinimui[i][0] == index)
            {
                mas[masindex] = tikrinimui[i][1];
                masindex++;
                flush++;

            }
        }
        if(flush >= 5)
        {
            max = mas[0];
            for(int i = 1; i < 5; i++)
            {
                if(max < mas[i])
                {
                    for(int j =0; j < 13; j++)
                    {
                        max = mas[i];
                        if(cards[i]== max)
                        {

                            win_cof_computer = 75+j;
                        }
                    }
                }

            }

        }
    }
    if(win_cof_computer > win_cof_human)
    {
        return 0;
    }
    else if(win_cof_computer< win_cof_human)
    {
        return 1;
    }
    else
    {
        return 2;
    }
}
