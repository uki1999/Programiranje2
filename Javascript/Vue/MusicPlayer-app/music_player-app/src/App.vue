<template>
  <div id="app">
    <header>
      <h1>Music</h1>
    </header>
    <main>
      <section class="player">
        <h2 class="song-title">{{ current.title }} - <span>{{ current.artist }}</span></h2>
        <div class="control">
          <buttton class="prev" @click="prev">Prev</buttton>
          <buttton class="play" v-if="!isPlaying" @click="play">Play</buttton>
          <buttton class="pause" v-else @click="pause">Pause</buttton>
          <buttton class="next" @click="next">Next</buttton>
        </div>
        <section class="playlist">
          <h3>The playlist</h3>
          <button v-for="song in songs" :key="song.src" @click="play(song)" :class="(song.src == current.src) ? 'song playing' : 'song'"> 
            {{ song.title }} - {{ song.artist }}
          </button>
        </section>
      </section>
    </main>
  </div>
</template>

<script>


export default {
  name: 'App',
  data () {
    return {
      current:{},
      index: 0,
      isPlaying: false,
      time:0,
      duration:0,
      songs: [
        {
          title: 'Ti si mi u mislima',
          artist: 'Dino Dvornik',
          src: require('./assets/dino_dvornik_ti_si_mi_u_mislima.mp3') 
        },
        {
          title: 'Get you the Moon',
          artist: 'Kina',
          src: require('./assets/Kina - Get You The Moon (Lyrics) ft. Snow.mp3') 
        },
        {
          title: 'Hypnotized',
          artist: 'Purple Disco Machine, Sophie And The Giants',
          src: require('./assets/Purple Disco Machine, Sophie And The Giants - Hypnotized (Acoustic Video).mp3') 
        }
      ],
      player: new Audio()
    }
  },
  methods: {
    play(song){
        if(typeof song.src != "undefined"){
          this.current = song;

          this.player.src = this.current.src;
        }
        this.player.play();
        this.player.addEventListener('ended', function(){
          this.index++;
          if (this.index > this.songs.length - 1){
            this.index = 0;
          }
          this.current = this.songs[this.index];
          this.play(this.current);
        }.bind(this));
        this.isPlaying = true;
    },
    pause(){
      this.player.pause();
      this.isPlaying = false;
    },
    next(){
      this.index++;
      if (this.index > this.songs.length - 1){
        this.index = 0;
      }
      this.current = this.songs[this.index];

      this.play(this.current);
  },
    prev(){
      this.index--;
      if (this.index < 0){
        this.index = this.songs.length - 1;
      }

      this.current = this.songs[this.index];
      this.play(this.current);
    }
  },
  created(){
    this.current = this.songs[this.index];
    this.player.src = this.current.src;
    this.player.play();
  }
}
</script>

<style>
*{
  margin:0;
  padding:0;
  box-sizing: border-box;
}
body{
  font-family: sans-serif;
}
header{
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 15px;
  background-color: #212121;
  color:#FFF;
}
main{
  width: 100%;
  max-width: 768px;
  margin: 0 auto;
  padding:25px;
}

.song-title{
  color:#212121;
  font-size: 32px;
  font-weight: 700;
  text-transform: uppercase;
  text-align: center;
}

.song-title span{
  font-weight: 400;
  font-style: italic;
}

.control{
  display: flex;
  justify-content: center;
  padding: 30px 15px;
  align-items:center;
}

button{
  appearance: none;
  background: none;
  border: none;
  outline: none;
  cursor: pointer;
}
.play{
  font-size: 20px;
  font-weight: 700;
  padding: 15px 25px;
  margin:0px 15px;
  border-radius: 8px;
  color:#FFF;
  background-color: #CC2E5D;
}
.pause {
  font-size: 20px;
  font-weight: 700;
  padding: 15px 25px;
  margin:0px 15px;
  border-radius: 8px;
  color:#FFF;
  background-color: #f52020;
}
button:hover{
  opacity: 0.8;
}
.next ,.prev{
  text-align: center;
  font-size: 16px;
  font-weight: 700;
  padding: 10px 20px;
  margin:0px 15px;
  border-radius: 6px;
  color:#FFF;
  background-color: #FF5858;
}
.playlist{
  padding:0px 30px;
}
.playlist h3{
  padding:0px 30px;
  font-size: 28px;
  font-weight: 400;
  margin-bottom: 30px;
  text-align: center;
}
.playlist .song{
  display: block;
  width: 100%;
  padding: 15px;
  font-size: 20px;
  font-weight: 700;
  cursor: pointer;
}
.playlist .song:hover{
  color:#FF5858;
}
.playlist .song.playing {
  color: #FFF;
  background-image: linear-gradient(to right, #CC2E5D, #FF5858);
}
</style>
