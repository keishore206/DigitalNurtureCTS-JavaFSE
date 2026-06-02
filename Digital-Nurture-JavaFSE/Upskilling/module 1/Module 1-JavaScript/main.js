// JavaScript Exercises - Local Community Event Portal
// Simple beginner style code

console.log("Welcome to the Community Portal");
console.log("Local Community Event Portal script loaded");

let formSubmitted = false;
let lastRegisteredEventIndex = -1;

// Task 2: const, let, template literals, ++ and --
const sampleEventName = "Music Festival";
const sampleEventDate = "2026-06-20";
let sampleSeats = 5;

let sampleInfo = `Event Name: ${sampleEventName}, Date: ${sampleEventDate}, Seats: ${sampleSeats}`;
console.log(sampleInfo);

// Task 5: Event constructor
function CommunityEvent(name, date, seats, category, location, fee, image) {
    this.name = name;
    this.date = date;
    this.seats = seats;
    this.category = category;
    this.location = location;
    this.fee = fee;
    this.image = image;
}

// Task 5: prototype method
CommunityEvent.prototype.checkAvailability = function () {
    if (this.seats > 0) {
        return true;
    } else {
        return false;
    }
};

// Task 6: array of all 6 community events
let events = [];

// Task 4: addEvent function
function addEvent(name, date, seats, category, location, fee, image) {
    let newEvent = new CommunityEvent(name, date, seats, category, location, fee, image);
    events.push(newEvent);
}

// Same 6 events used everywhere
addEvent("Music Festival", "2026-06-20", 5, "Music", "Town Hall", 100, "music.jpg");
addEvent("Food Fair Event", "2026-06-22", 6, "Food", "Old Street", 40, "food.webp");
addEvent("Community Sports Day", "2026-06-25", 3, "Sports", "City Ground", 50, "sports.jpg");
addEvent("Book Exhibition", "2026-07-01", 7, "Education", "Library Hall", 30, "book.jpg");
addEvent("Medical Camp", "2026-07-02", 8, "Health", "Primary Health Center", 0, "med.webp");
addEvent("Tree Planting", "2026-07-15", 4, "Environment", "Lake Park", 0, "tree.webp");

// Task 4: closure to track total registrations for category
function makeRegistrationCounter(categoryName) {
    let total = 0;

    return function () {
        total++;
        console.log(`Total ${categoryName} registrations: ${total}`);
        return total;
    };
}

let musicRegistrationCounter = makeRegistrationCounter("Music");

// Task 4: higher order function with callback
function filterEventsByCategory(category, callback) {
    let filteredEvents = events.filter(function (oneEvent) {
        if (category == "all") {
            return true;
        } else {
            return oneEvent.category == category;
        }
    });

    callback(filteredEvents);
}

// Task 10: default parameter
function showMessage(message = "Welcome to events") {
    console.log(message);
}

showMessage();

// Task 7: DOM elements using querySelector
let eventList = document.querySelector("#eventList");
let categoryFilter = document.querySelector("#categoryFilter");
let searchBox = document.querySelector("#searchBox");
let selectedEvent = document.querySelector("#selectedEvent");
let loadingText = document.querySelector("#loadingText");

// Fill the registration dropdown with all 6 events
function fillSelectedEventDropdown() {
    selectedEvent.innerHTML = '<option value="">Choose Event</option>';

    events.forEach(function (oneEvent) {
        let option = document.createElement("option");
        option.value = oneEvent.name;
        option.innerHTML = oneEvent.name;
        selectedEvent.appendChild(option);
    });
}

// Task 3 and 7: display only valid upcoming events with seats
function displayEvents(eventArray) {
    eventList.innerHTML = "";

    let today = new Date();
    today.setHours(0, 0, 0, 0);

    eventArray.forEach(function (oneEvent) {
        let eventDate = new Date(oneEvent.date);

        if (eventDate >= today && oneEvent.checkAvailability()) {
            let card = document.createElement("div");
            card.className = "js-event-card eventCard";

            // Task 10: destructuring
            let { name, date, seats, category, location, fee, image } = oneEvent;

            let realIndex = events.indexOf(oneEvent);

            card.innerHTML = `
                <img src="${image}" alt="${name}" class="small-card-image">
                <h3>${name}</h3>
                <p>Date: ${date}</p>
                <p>Category: ${category}</p>
                <p>Location: ${location}</p>
                <p>Fee: ₹${fee}</p>
                <p>Seats Left: <span id="seat${realIndex}">${seats}</span></p>
                <button onclick="registerUser(${realIndex})">Register</button>
                <button onclick="cancelOneEvent(${realIndex})">Cancel</button>
            `;

            eventList.appendChild(card);
        } else {
            console.log(oneEvent.name + " is hidden because it is old or full");
        }
    });
}

// Task 4 and 3: registration logic with try-catch
function registerUser(index) {
    try {
        if (events[index].seats <= 0) {
            throw "No seats available";
        }

        events[index].seats--;
        sampleSeats--;
        lastRegisteredEventIndex = index;

        if (events[index].category == "Music") {
            musicRegistrationCounter();
        }

        document.getElementById("confirmation").value =
            "Registered for " + events[index].name;

        displayEvents(events);
        showMusicAndFormattedLists();
    } catch (error) {
        alert("Registration Error: " + error);
    }
}

// Cancel one event seat and use ++ operator
function cancelOneEvent(index) {
    events[index].seats++;
    sampleSeats++;

    document.getElementById("confirmation").value =
        "Registration cancelled for " + events[index].name;

    displayEvents(events);
    showMusicAndFormattedLists();
}

// Cancel last registration
function cancelRegistration() {
    if (lastRegisteredEventIndex >= 0) {
        cancelOneEvent(lastRegisteredEventIndex);
        lastRegisteredEventIndex = -1;
    } else {
        alert("No registration to cancel");
    }
}

// Task 6: filter music and map display cards
function showMusicAndFormattedLists() {
    let musicEvents = events.filter(function (oneEvent) {
        return oneEvent.category == "Music";
    });

    let musicList = document.querySelector("#musicList");
    musicList.innerHTML = "";

    musicEvents.forEach(function (oneEvent) {
        let li = document.createElement("li");
        li.innerHTML = oneEvent.name;
        musicList.appendChild(li);
    });

    let formattedNames = events.map(function (oneEvent) {
        return "Workshop on " + oneEvent.name;
    });

    let formattedList = document.querySelector("#formattedList");
    formattedList.innerHTML = "";

    formattedNames.forEach(function (name) {
        let li = document.createElement("li");
        li.innerHTML = name;
        formattedList.appendChild(li);
    });
}

// Task 5: Object.entries()
function showObjectEntries() {
    let objectDetails = document.querySelector("#objectDetails");
    objectDetails.innerHTML = "";

    let firstEvent = events[0];
    let entries = Object.entries(firstEvent);

    entries.forEach(function (item) {
        let p = document.createElement("p");
        p.innerHTML = item[0] + " : " + item[1];
        objectDetails.appendChild(p);
    });
}

// Task 8: onchange filter
categoryFilter.onchange = function () {
    let selectedCategory = categoryFilter.value;

    filterEventsByCategory(selectedCategory, function (result) {
        // Task 10: spread operator clone before filtering/displaying
        let clonedEvents = [...result];
        displayEvents(clonedEvents);
    });
};

// Task 8: keydown quick search by name
searchBox.onkeydown = function () {
    setTimeout(function () {
        let text = searchBox.value.toLowerCase();

        let searchedEvents = events.filter(function (oneEvent) {
            return oneEvent.name.toLowerCase().includes(text);
        });

        displayEvents(searchedEvents);
    }, 100);
};

// Task 9: fetch using then and catch
function fetchEventsUsingThen() {
    fetch("events.json")
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            console.log("Events loaded using then:", data);
        })
        .catch(function (error) {
            console.log("Fetch then/catch error:", error);
        });
}

// Task 9: async await with loading text
async function fetchEventsUsingAsync() {
    loadingText.innerHTML = "Loading events...";

    try {
        let response = await fetch("events.json");
        let data = await response.json();

        console.log("Events loaded using async await:", data);
        loadingText.innerHTML = "Events loaded successfully";
    } catch (error) {
        loadingText.innerHTML = "Local events are shown because fetch failed";
        console.log("Async await fetch error:", error);
    }
}

// Previous HTML task functions kept safely
function checkPhone() {
    let phone = document.getElementById("phone").value;

    if (phone.length != 10) {
        document.getElementById("phoneError").innerHTML =
            "Phone number must be 10 digits";
    } else {
        document.getElementById("phoneError").innerHTML = "";
    }
}

function showFee() {
    let eventType = document.getElementById("eventType");
    let selectedOption = eventType.options[eventType.selectedIndex];
    let fee = selectedOption.getAttribute("data-fee");
    let selectedEventName = eventType.value;

    console.log("Selected event is:", selectedEventName);
    console.log("Selected event fee is:", fee);

    localStorage.setItem("preferredEvent", selectedEventName);
    sessionStorage.setItem("lastSelectedEvent", selectedEventName);

    if (selectedEventName == "") {
        document.getElementById("eventFee").innerHTML = "";
    } else {
        document.getElementById("eventFee").innerHTML =
            "Selected Event Fee: ₹" + fee;
    }
}

function showRegisterMessage() {
    console.log("Register button clicked");
}

function enlargeImage(image) {
    image.classList.toggle("big-image");
}

function countCharacters() {
    let text = document.getElementById("feedbackText").value;
    document.getElementById("charCount").innerHTML = text.length;
}

function videoReady() {
    document.getElementById("videoMessage").innerHTML =
        "Video ready to play";
}

function clearPreferences() {
    localStorage.clear();
    sessionStorage.clear();

    document.getElementById("eventType").value = "";
    document.getElementById("eventFee").innerHTML = "";

    alert("Preferences cleared!");
}

function findNearbyEvents() {
    if (navigator.geolocation) {
        document.getElementById("locationResult").innerHTML =
            "Finding your location...";

        navigator.geolocation.getCurrentPosition(
            showLocation,
            showLocationError,
            {
                enableHighAccuracy: true,
                timeout: 10000,
                maximumAge: 0
            }
        );
    } else {
        document.getElementById("locationResult").innerHTML =
            "Geolocation is not supported by this browser.";
    }
}

function showLocation(position) {
    let latitude = position.coords.latitude;
    let longitude = position.coords.longitude;

    document.getElementById("locationResult").innerHTML =
        "Latitude: " + latitude + "<br>Longitude: " + longitude;
}

function showLocationError(error) {
    if (error.code == 1) {
        document.getElementById("locationResult").innerHTML =
            "Permission denied. Please allow location access.";
    } else if (error.code == 2) {
        document.getElementById("locationResult").innerHTML =
            "Location unavailable.";
    } else if (error.code == 3) {
        document.getElementById("locationResult").innerHTML =
            "Location request timed out.";
    } else {
        document.getElementById("locationResult").innerHTML =
            "An unknown error occurred.";
    }
}

// Task 11 and 12: form work, validation, POST, setTimeout
let eventForm = document.getElementById("eventForm");

if (eventForm != null) {
    eventForm.addEventListener("submit", function (event) {
        event.preventDefault();

        console.log("Form submit started");

        let form = event.target;
        let name = form.elements["name"].value;
        let email = form.elements["email"].value;
        let selectedEventName = form.elements["selectedEvent"].value;

        document.getElementById("nameError").innerHTML = "";
        document.getElementById("emailError").innerHTML = "";
        document.getElementById("eventError").innerHTML = "";

        let isValid = true;

        if (name == "") {
            document.getElementById("nameError").innerHTML = "Name is required";
            isValid = false;
        }

        if (email == "") {
            document.getElementById("emailError").innerHTML = "Email is required";
            isValid = false;
        } else if (email.indexOf("@") == -1) {
            document.getElementById("emailError").innerHTML = "Enter valid email";
            isValid = false;
        }

        if (selectedEventName == "") {
            document.getElementById("eventError").innerHTML = "Please select JS event";
            isValid = false;
        }

        if (isValid == true) {
            let userData = {
                name: name,
                email: email,
                event: selectedEventName
            };

            console.log("Payload is:", userData);

            document.getElementById("postMessage").innerHTML = "Sending registration...";

            setTimeout(function () {
                fetch("https://jsonplaceholder.typicode.com/posts", {
                    method: "POST",
                    body: JSON.stringify(userData),
                    headers: {
                        "Content-type": "application/json; charset=UTF-8"
                    }
                })
                    .then(function (response) {
                        return response.json();
                    })
                    .then(function (data) {
                        console.log("Server response:", data);
                        document.getElementById("confirmation").value =
                            "Registration Successful! Welcome " + name;
                        document.getElementById("postMessage").innerHTML =
                            "Registration sent to server successfully";
                        formSubmitted = true;
                    })
                    .catch(function (error) {
                        console.log("POST failed:", error);
                        document.getElementById("postMessage").innerHTML =
                            "Registration failed. Check Network tab.";
                    });
            }, 1000);
        }
    });
}

window.onload = function () {
    alert("Page fully loaded");

    let savedEvent = localStorage.getItem("preferredEvent");

    if (savedEvent != null) {
        document.getElementById("eventType").value = savedEvent;
        showFee();
    }

    fillSelectedEventDropdown();
    displayEvents(events);
    showMusicAndFormattedLists();
    showObjectEntries();
    fetchEventsUsingThen();
    fetchEventsUsingAsync();
};

window.onbeforeunload = function () {
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;

    if (formSubmitted == false && (name != "" || email != "")) {
        return "You have unfinished form data!";
    }
};

// Task 14: jQuery simple examples
// This will run only if jQuery is loaded from internet
if (window.jQuery) {
    $(document).ready(function () {
        $("#registerBtn").click(function () {
            console.log("jQuery register button click working");
        });

        $("#categoryFilter").change(function () {
            $(".js-event-card").fadeOut(100).fadeIn(300);
        });
    });
}
