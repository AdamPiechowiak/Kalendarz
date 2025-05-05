import csv
import datetime
import tkinter as tk


def read_data():

    tab = []
    
    with open('/home/adam/projekty/Kalendarz/date.csv') as csvfile:
 
        csvreader = csv.reader(csvfile, dialect='excel')
    
        for row in csvreader:
            tab.append(row)
        
    return tab
    
def prepare_dates(dates):
    
    now = datetime.datetime.date(datetime.datetime.now())
    
    return_dates = []
    
    for d in dates:
    
        if d[0] == "O":
        
            return_dates.append(d)
            
        elif d[0] == "M":
            
            prepare = d.copy()
            
            d[1] = str(now.year) + f"-{now.month:=02}-" + d[1]
            
            if(now.month == 12):
                prepare[1] = str(now.year+1) + "-01-" + prepare[1]
            else:
                prepare[1] = str(now.year) + f"-{now.month+1:=02}-" + prepare[1]
            
            return_dates.append(d)
            return_dates.append(prepare)
            
        elif d[0] == "Y":
            
            prepare = d.copy()
            
            d[1] = str(now.year) + "-" + d[1]
            prepare[1] = str(now.year+1) + "-" + prepare[1]
            
            return_dates.append(d)
            return_dates.append(prepare)
        
    
    return return_dates
    
def upcoming_dates(dates):

    return_dates=[]
    
    now = datetime.datetime.date(datetime.datetime.now())
    delta = datetime.timedelta(days=5)

    for d in dates:
    
        delta_now = datetime.date.fromisoformat(d[1]) - now
    
        if delta_now > datetime.timedelta(days=-1) and delta_now < delta:
            return_dates.append(d)

    return return_dates
    
def create_message(dates):

    message=""
    for d in dates:

        message+=f"{d[1]} {d[2]}\n"

    return message[:-1]

dates = read_data()
dates = prepare_dates(dates)
for d in dates:
    print(d)

show_dates = upcoming_dates(dates)
message = create_message(show_dates)


#Create the main window
root = tk.Tk()
root.title("Kalendarz")

#Create a label with a message
label = tk.Label(root, text=message, font=("Helvetica", 16), justify="left")
label.pack(pady=10, padx=20)

#Run the application
root.mainloop()
