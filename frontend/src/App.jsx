import React from 'react'
import Navbar from './Components/Navbar'
import { Route, Routes } from 'react-router'
import Home from './Components/Home'
import EditProduct from './Components/EditProduct'
import AddProduct from './Components/AddProduct'
const App = () => {
  return (
    <>
    
    <Navbar/>

    <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/addProduct" element={<AddProduct/>}/>
        <Route path="/editProduct/:id" element={<EditProduct/>}/>
    </Routes>
    

    </>
  )
}

export default App