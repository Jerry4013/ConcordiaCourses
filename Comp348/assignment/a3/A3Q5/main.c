//IMPORTANT NOTES: I use Clion IDE, so the output.txt file
//must be placed in the cmake-build-debug folder
//The version of c is c99
//I am using MicroSoft Visual Studio Compiler, so for some functions I have to use fopen_s scanf_s...
//Add2Inventory is passing a fix String now. The String in line 65 can be modified for testing


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct carMaker {
    char car_maker[30];
    struct carMaker *next;
    struct carModel *blow;
};
struct carModel {
    char km[30];
    char type[30];
    char transmission[30];
    char stock[30];
    char drivetrain[10];
    char status[10];
    char fuel[30];
    char car_maker[30];
    char car_model[30];
    char year[10];
    char trim[10];
    char set_of_features[200];
    struct carModel *next;
};
struct carMaker *makerHead = NULL;
struct carModel * populate(char *line, struct carModel *car);
int numberOfCars = 0;
int searchInventory(char *searchMaker);
int Add2Structure(char *line);
int Add2Inventory(char *line);
int write2File(struct carModel *carArray);
int saveCatalogue2File();
int carCompare(const void *c1, const void *c2);
int main() {

    FILE *stream;
    char line[500];
    errno_t err = fopen_s( &stream, "output.txt", "r" );
    if( err ){
        printf_s( "The file output.txt was not opened\n" );
    } else {
        while (fgets(line, sizeof(line), stream)) {
            if (strcmp(line, "\n")){
                numberOfCars++;
                printf("We are creating car #%d: \n%s\n", numberOfCars, line);
                Add2Structure(line);
            }
        }
        fclose( stream );
    }

    //SearchInventory Test
    char maker[20];
    printf("\nEnter the car maker name you want to search: ");
    scanf_s("%s", maker,(unsigned)_countof(maker));
    searchInventory(maker);

    //Add2Inventory Test
    char newLine[] = "Mercedes,GLK,LX, 888km,2018,coupe, RWD, auto, 18FO724A,Used,6L/100km,{AC, Heated Seats, Heated Mirrors, Keyless Entry, Power seats}";
    Add2Inventory(newLine);

    //SearchInventory again
    printf("Search the same car maker again: ");
    scanf_s("%s", maker,(unsigned)_countof(maker));
    searchInventory(maker);

    //saveCatalogue2File Test
    saveCatalogue2File();
}

struct carModel * populate(char *line, struct carModel *car){
    char *feature;
    int i = 0;
    while (line[i] != '{'){
        i++;
    }
    feature = &line[i];
    strcpy_s(car->set_of_features, 200, feature);
    char *token = NULL;
    char *next_token = NULL;
    token = strtok_s(line , ", ", &next_token);
    strcpy_s(car->car_maker, 30, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->car_model, 30, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->trim, 10, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->km, 30, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->year, 10, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->type, 30, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->drivetrain, 10, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->transmission, 30, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->stock, 30, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->status, 10, token);

    token = strtok_s(NULL , ", ", &next_token);
    strcpy_s(car->fuel, 30, token);

    car->next = NULL;
    return car;
}

int searchInventory(char *searchMaker){
    struct carMaker *current;
    current = makerHead;
    while (current != NULL && strcmp(searchMaker, current->car_maker) != 0){
        current = current->next;
    }
    if (current){
        struct carModel *car;
        car = current->blow;
        if (car == NULL){
            printf("Error: Out of memory.\n");
            return 1;
        }
        printf("Searching result is:\n");
        while (car){
            printf("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n",
                    car->car_maker, car->car_model, car->trim, car->km, car->year,car->type,
                    car->drivetrain, car->transmission, car->stock, car->status, car->fuel,
                    car->set_of_features);
            car = car->next;
        }
    } else {
        printf("%s", "This car maker does not exist in our inventory");
    }
    return 0;
}

//Accepts a new listing as a single line of ORDERED listing features
int Add2Structure(char *line){
    struct carModel *newCar;
    newCar = malloc(sizeof(struct carModel));
    newCar = populate(line, newCar);
    struct carMaker *current;
    current = makerHead;
    while (current != NULL && strcmp(current->car_maker, newCar->car_maker) != 0){
        current = current->next;
    }
    if (current == NULL){
        struct carMaker *newMaker;
        newMaker = malloc(sizeof(struct carMaker));
        newMaker->next = makerHead;
        strcpy_s(newMaker->car_maker, 30, newCar->car_maker);
        makerHead = newMaker;
        newMaker->blow = newCar;
    } else {
        newCar->next = current->blow;
        current->blow = newCar;
    }
    return 0;
}

int Add2Inventory(char *line){
    FILE *stream;
    errno_t err = fopen_s( &stream, "output.txt", "a" );
    if( err ){
        printf_s( "The file output.txt was not opened\n" );
    } else {
        fprintf(stream, "\n%s", line);
        printf("We are adding this car to the inventory:\n%s\n\n",line);
        Add2Structure(line);
        fclose( stream );
    }
    return 0;
}

int saveCatalogue2File(){
    struct carModel *carArray;
    carArray = malloc(sizeof(struct carModel) * numberOfCars);
    struct carMaker *current;
    current = makerHead;
    int carCounter = 0;
    while (current){
        struct carModel *carCurrent = current->blow;
        while (carCurrent){
           *(carArray + carCounter) = *carCurrent;
            carCounter++;
            carCurrent = carCurrent->next;
        }
        current = current->next;
    }
    qsort(&carArray, numberOfCars, sizeof(struct carModel),carCompare);
    write2File(carArray);
    free(carArray);
    return 0;
}
int write2File(struct carModel *carArray){
    FILE *stream;
    printf("\nTest Point");
    errno_t err = fopen_s( &stream, "output.txt", "r" );
    printf("\nTest Point");
    if( err ){
        printf_s( "The file output2.txt was not opened\n" );
    } else {
        struct carModel *car;
        printf("\nWe are writing cars to file...\n\n");
        for (int i = 0; i < numberOfCars; ++i) {
            car = &carArray[i];
            fprintf(stream, "%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n",
                   car->car_maker, car->car_model, car->trim, car->km, car->year,car->type,
                   car->drivetrain, car->transmission, car->stock, car->status, car->fuel,
                   car->set_of_features);
        }
        printf("Finish!");
        fclose( stream );
    }
    return 0;
}

int carCompare(const void *c1, const void *c2) {
    char *l = ((struct carModel *)c1)->car_maker;
    char *r = ((struct carModel *)c2)->car_maker;
    return strcmp(l, r);
}





