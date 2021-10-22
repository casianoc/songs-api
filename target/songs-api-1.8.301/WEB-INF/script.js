document.addEventListener("DOMContentLoaded", function(){

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){

        if(xhr.readyState === 4){
            console.log(JSON.parse(xhr.responseText));      // send the parsed JSON to the console to make sure GET request working properly 

            var songArray = JSON.parse(xhr.responseText);   

            songArray.array.forEach(songElement => {
                addSongToTable(songElement);
            });
        }
    }

    xhr.open('GET', '/songs-api/api/songs');

    xhr.send();
});

function addSongToTable(song){

    var tr = document.createElement('tr');
    var id = document.createElement('td');
    var name = document.createElement('td');           
    var length = document.createElement('td');
    var rating = document.createElement('td');
    var artistName = document.createElement('td');
    var albumName = document.createElement('td');
    var genre = document.createElement('td');
    var yearReleased = document.createElement('td');
    var edit = document.createElement('td');

    id.innerText = song.id
    name.innerText = song.name
    length.innerText = song.length
    rating.innerText = song.rating
    artistName.innerText = song.artistName
    albumName.innerText = song.albumName
    genre.innerText = song.genre
    yearReleased.innerText = song.yearReleased

    tr.appendChild(id);
    tr.appendChild(name);
    tr.appendChild(length);
    tr.appendChild(rating);
    tr.appendChild(artistName);
    tr.appendChild(albumName);
    tr.appendChild(genre);
    tr.appendChild(yearReleased);

    document.getElementById('song-table-body').appendChild(tr);
}

document.getElementById('new-song-form').addEventListener('submit', function(event) {

    event.preventDefault();

    var nameOnForm = document.getElementById('song-name').value;       // gets the data in the name input box
    var ratingOnForm = document.getElementById('song-rating').value;
    var lengthOnForm = document.getElementById('song-length').value;
    var artistNameOnForm = document.getElementById('song-artist-name').value;
    var albumNameOnForm = document.getElementById('song-album-name').value;
    var genreOnForm = document.getElementById('song-genre').value;
    var yearReleasedOnForm = document.getElementById('song-year-released').value;

    var song = {
        name : nameOnForm,
        rating : ratingOnForm, 
        length : lengthOnForm,
        artistName : artistNameOnForm,
        albumName : albumNameOnForm,
        genre : genreOnForm,
        yearReleased : yearReleasedOnForm

    };

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){

        if(xhr.readyState === 4){
            var updatedSong = JSON.parse(xhr.responseText);

            addSongToTable(updatedSong);

            document.getElementById("new-song-form").reset();
        }
    }

    xhr.open('POST', '/songs-api/api/songs');

    xhr.send(JSON.stringify(song));
});

document.getElementById('song-table-body').addEventListener('delete', function(event){

    event.preventDefault;

    let xhr = new XMLHttpRequest();

    if(xhr.readyState === 4){
        document.getElementById("song-table-body").deleteRow();
    }

    xhr.open('DELETE', '/songs-api/api/songs');
});

document.getElementById('song-table-body').addEventListener('edit', function(event){

    event.preventDefault();

    var nameOnForm = document.getElementById('song-name').value;       // gets the data in the name input box
    var ratingOnForm = document.getElementById('song-rating').value;
    var lengthOnForm = document.getElementById('song-length').value;
    var artistNameOnForm = document.getElementById('song-artist-name').value;
    var albumNameOnForm = document.getElementById('song-album-name').value;
    var genreOnForm = document.getElementById('song-genre').value;
    var yearReleasedOnForm = document.getElementById('song-year-released').value;

    var song = {
        name : nameOnForm,
        rating : ratingOnForm, 
        length : lengthOnForm,
        artistName : artistNameOnForm,
        albumName : albumNameOnForm,
        genre : genreOnForm,
        yearReleased : yearReleasedOnForm

    };

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){

        if(xhr.readyState === 4){
            var updatedSong = JSON.parse(xhr.responseText);

            addSongToTable(updatedSong);

    xhr.open('PUT', '/songs-api/api/songs');
    }
}
});