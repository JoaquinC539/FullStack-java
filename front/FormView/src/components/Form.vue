<script setup>
import axios from 'axios';

</script>
<script>

const headers={'Content-Type':'application/json'};
export default{
   props:['api'],
  name:"Form",
  data(){
    return{
      name:"",
      day:"",
      month:"",
      year:"",
      error:"",
      message:""     
    };
  },
  methods:{
    submitForm(){
        console.log(this.api);
      const data={
        name:this.name,
        birth:`${this.day}/${this.month}/${this.year}`
      };
      try {
      axios.post(this.api,JSON.stringify(data),{headers})
      .then((response)=>{
        this.error="";
        console.log(response);
        if(response.data.body.error){
            this.error="Usuario no registrado";
        }else{this.message="Usuario registrado"};}
      )
      .catch((error)=>{console.log(error);this.message="";this.error=error});
      this.name="";
      this.day="";
      this.year="";
      this.month="";

    }catch(error){console.log(error)}
}
  }
}
</script>

<template>
<form  v-on:submit.prevent="submitForm()">
  <div class="mb-3 container" >
    <div class="header">
      <label for="name" class="form-label name">Nombre: </label>
    <input type="text" id="name" class="form-control nameInput" aria="none" v-model="name">
    </div>
    <label for="birth" class="form-label birth">Fecha de nacimiento: </label>
    <div class="mb-3 labels">
      <label for="day" class="form-label regLabel">Día:</label>
      <input type="number" id="day" aria="none" class="form-label reg" required v-model="day">
      <label for="month" class="form-label regLabel">Mes:</label>
      <input type="number" id="month" aria="none" class="form-label reg"  required v-model="month">
      <label for="year" class="form-label regLabel">Año:</label>
      <input type="number" id="year" aria="none" class="form-label regYear" required v-model="year">
  </div>
  <button type="submit" class="btn btn-primary" >Mandar información</button>
    <p class="message"><span v-if="message">{{ message }}</span></p>
    <p class="message"><span v-if="error">{{ error }}</span></p>

  </div>
</form>
</template>

<style>
*{
  margin-left: 2px;
}
.container{
  border: solid 1px#0d6efd;
  margin: 2em 0em 0em 0.8em;
  width: 90%;
  text-align: center;
  
}
.header{
  display: flex;
  flex-direction: column;
}
.form-label{
  padding: 0.2em;
}
label{
  margin-left: 0.2rem;
  padding: 2px;

}
.birth{
  margin-bottom: 1em;
}
.labels{
  display: flex;
  flex-direction:row;
}
.regLabel{
  padding: 0 1em 0 1em;
}
.reg{
  width: 10%;
  border: solid 1px #979696;
}
.regYear{
  width: 16%;
  border: solid 1px #979696;
}
.nameInput{
  width: 28%;
  align-self: center;
}
.btn{
  margin-bottom: 0.3em;
}

</style>