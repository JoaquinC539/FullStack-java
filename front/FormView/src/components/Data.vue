<script>
import axios from 'axios';
import { eventBus } from '@/eventBus.js';
export default {
    name: "Data",
    props: ['api'],
    data() {
        return {
            fetchData: [],
            error: "",

        };
    },
    methods: {
        fetchDataFromApi() {
            this.fetchData = axios.get(this.api)
                .then(response => {
                    this.fetchData = response.data;

                })
                .catch(error => {
                    console.error(error);
                    this.error = error;
                });
        }
    },
    created() {
        this.fetchDataFromApi();
        

    },
    mounted() {
        eventBus.subscribe(eventName=>{
            if(eventName==='formSubmitted'){
                this.fetchDataFromApi();
            }
        })
    },
    beforeUnmount(){
        eventBus.unsubscribe();
    }
    
}

</script>
<template>
    <button class="btn btn-primary" v-on:click="fetchDataFromApi()">Volver a Pedir información</button>
    <div>
        <ul>
            <li v-for="item in fetchData" :key="item.id">
                Nombre: {{ item.name }} Fecha de nacimiento: {{ item.birth }}
            </li>
        </ul>
    </div>
</template>

<style></style>