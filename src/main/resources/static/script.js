const list = document.getElementById("countryList");
const search = document.getElementById("search");

let countries = [];

fetch("/api/countries")
    .then(res => res.json())
    .then(data => {
        countries = data;
        display(data);
    });

function display(data) {
    list.innerHTML = "";
    data.forEach(c => {
        const li = document.createElement("li");
        li.textContent = `${c.name} - ${c.capital}`;
        list.appendChild(li);
    });
}

search.addEventListener("input", () => {
    const value = search.value.toLowerCase();
    const filtered = countries.filter(c =>
        c.name.toLowerCase().includes(value)
    );
    display(filtered);
});
