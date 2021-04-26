<template>
  <div class="about">
    <h1>Min funktsioon</h1>
    <input v-model="minA"/>
    <input v-model="minB"/>
    <button v-on:click="min()">Miinimum</button>
    Miinimum on: {{minAnswer}}
  </div>
</template>


<script>
function min() {
  if(this.minA < this.minB){
    this.minAnswer = this.minA;
  } else {
    this.minAnswer = this.minB;
  }
}

export default {
  name: 'Home',
  methods: {
    min: min
  }, data: function (){
    return {
      minA: 0,
      minB: 0,
      minAnswer: 0
    }
  }
}
</script>
