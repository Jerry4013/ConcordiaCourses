//IMPORTANT NOTES: I use Clion IDE, so the output.txt file
//                  must be placed in the cmake-build-debug folder
//The version of c compiler is c99
//Add2Inventory is passing a fix String now. The String in line 61 can be modified for testing

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
    //IMPORTANT NOTES: I use Clion IDE, so the output.txt file
    //                  must be placed in the cmake-build-debug folder
    FILE *stream;
    char line[500];
    stream = fopen("output.txt", "r" );
    while (fgets(line, sizeof(line), stream)) {
        if (strcmp(line, "\n")){
            numberOfCars++;
            printf("We are creating car #%d: \n%s\n", numberOfCars, line);
            Add2Structure(line);
        }
    }
    fclose( stream );

    //SearchInventory Test
    char maker[20];
    printf("\nEnter the car maker name you want to search: ");
    scanf("%s", maker);
    searchInventory(maker);

    //Add2Inventory Test
    char newLine[] = "Mercedes,GLK,LX, 888km,2018,coupe, RWD, auto, 18FO724A,Used,6L/100km,{AC, Heated Seats, Heated Mirrors, Keyless Entry, Power seats}";
    Add2Inventory(newLine);

    //SearchInventory again
    printf("Search the same car maker again: ");
    scanf("%s", maker);
    searchInventory(maker);

    //saveCatalogue2File Test, print all the cars to the file ascending
    saveCatalogue2File();

}

struct carModel * populate(char *line, struct carModel *car){
    char *feature;
    int i = 0;
    while (line[i] != '{'){
        i++;
    }
    feature = &line[i];
    strcpy(car->set_of_features, feature);
    char *token = NULL;
    const char s[3] = ", ";
    token = strtok(line , ", ");
    strcpy(car->car_maker, token);

    token = strtok(NULL, s);
    strcpy(car->car_model, token);

    token = strtok(NULL, s);
    strcpy(car->trim, token);

    token = strtok(NULL, s);
    strcpy(car->km, token);

    token = strtok(NULL, s);
    strcpy(car->year, token);

    token = strtok(NULL, s);
    strcpy(car->type, token);

    token = strtok(NULL, s);
    strcpy(car->drivetrain, token);

    token = strtok(NULL, s);
    strcpy(car->transmission, token);

    token = strtok(NULL, s);
    strcpy(car->stock, token);

    token = strtok(NULL, s);
    strcpy(car->status, token);

    token = strtok(NULL, s);
    strcpy(car->fuel, token);

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
        strcpy(newMaker->car_maker, newCar->car_maker);
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
    stream = fopen("output.txt", "a" );
    if( stream == NULL ){
        printf( "The file output.txt was not opened\n" );
        return 1;
    }
    fprintf(stream, "\n%s", line);
    printf("We are adding this car to the inventory:\n%s\n\n",line);
    Add2Structure(line);
    numberOfCars++;
    fclose( stream );

    return 0;
}

int saveCatalogue2File(){
    struct carModel carArray[20];
    struct carMaker *current;
    current = makerHead;
    int i = 0;
    struct carModel *carCurrent;
    while (current){
        carCurrent = current->blow;
        while (carCurrent){
            strcpy(carArray[i].car_maker, carCurrent->car_maker);
            strcpy(carArray[i].car_model, carCurrent->car_model);
            strcpy(carArray[i].trim, carCurrent->trim);
            strcpy(carArray[i].km, carCurrent->km);
            strcpy(carArray[i].year, carCurrent->year);
            strcpy(carArray[i].type, carCurrent->type);
            strcpy(carArray[i].drivetrain, carCurrent->drivetrain);
            strcpy(carArray[i].transmission, carCurrent->transmission);
            strcpy(carArray[i].stock, carCurrent->stock);
            strcpy(carArray[i].status, carCurrent->status);
            strcpy(carArray[i].fuel, carCurrent->fuel);
            strcpy(carArray[i].set_of_features, carCurrent->set_of_features);
            carArray[i].next = NULL;
            i++;
            carCurrent = carCurrent->next;
        }
        current = current->next;
    }
    qsort(&carArray, (size_t) numberOfCars, sizeof(struct carModel), carCompare);
    write2File(carArray);
    return 0;
}

int write2File(struct carModel *carArray){
    FILE *stream;
    stream = fopen("output2.txt", "w" );
    if( stream == NULL ){
        printf( "The file output2.txt was not opened\n" );
        exit(1);
    }
    printf("\nWe are writing cars to file...\n\n");
        for (int i = 0; i < numberOfCars; ++i) {
            fprintf(stream, "%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n",
                    carArray[i].car_maker, carArray[i].car_model,carArray[i].trim,
                    carArray[i].km, carArray[i].year,carArray[i].type,
                    carArray[i].drivetrain, carArray[i].transmission, carArray[i].stock,
                    carArray[i].status, carArray[i].fuel,
                    carArray[i].set_of_features);
        }
    printf("Finish! All the cars have been printed in a new file output2.txt.");
    fclose( stream );

    return 0;
}

int carCompare(const void *c1, const void *c2) {
    char *l = ((struct carModel *)c1)->car_maker;
    char *r = ((struct carModel *)c2)->car_maker;
    if (strcmp(l, r) == 0){
        l = ((struct carModel *)c1)->car_model;
        r = ((struct carModel *)c2)->car_maker;
        return strcmp(l, r);
    }
    return strcmp(l, r);
}