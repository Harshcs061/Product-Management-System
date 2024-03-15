import React from 'react'
import { useState } from 'react'
import productservice from '../Service/productservice';
const EditProduct = () => {
  
   
    
    const [product,setProduct]= useState({
        productName : "",
        description : "",
        price : "",
        status : ""
    });

    // const [color,setColor]=useState("blue");

    const [msg,setMsg]=useState("");

    const handleChange = (e)=>{
        const value=e.target.value;
        setProduct({...product,[e.target.name]:value});
    };

    const productRegister= (e) =>{
        e.preventDefault();
        productservice.saveProduct(product).then((res)=>{
            // setColor("green");
            setMsg("Product Added Successfully");
            setProduct({
                productName : "",
                description : "",
                price : "",
                status : ""
            });
        }).catch((error)=>{
            console.log(error);
            // setColor("red");
        });
    };




  return (
    <>
    
    <div className="container">

    <div className="row">
        <div className="col-md-6 offset-md-3">
            <div className="card mt-3">
                <div className="card-header fs-3 text-center">
                    Add Product
                </div>
                {
                    msg && <p className="fs-4 text-center text-success">{msg}</p>

                
                }
                <div className="card-body ">

                <form onSubmit={(e)=> productRegister(e)}>

                <div className="mb-3">
                    <label htmlFor="">Enter Product Name</label>
                    <input type="text" name="productName"
                    className="form-control"
                    onChange={(e)=>handleChange(e)}
                    value={product.productName}/>
                </div>

                <div className="mb-3">
                    <label htmlFor="">Enter Description</label>
                    <input type="text" name="description"
                    className="form-control"
                    onChange={(e)=>handleChange(e)}
                    value={product.description}/>
                </div>

                <div className="mb-3">
                    <label htmlFor="">Enter Price</label>
                    <input type="text" name="price"
                    className="form-control"
                    onChange={(e)=>handleChange(e)}
                    value={product.price}/>
                </div>

                <div className="mb-3">
                    <label htmlFor="">Enter Status</label>
                    <input type="text" name="status"
                    className="form-control"
                    onChange={(e)=>handleChange(e)}
                    value={product.status}/>
                </div>

                <button className='btn btn-secondary col-md-12 my_btn'>Submit</button>


                </form>

                </div>
            </div>
        </div>
    </div>

    </div>
    
    </>
  )
    
  
}

export default EditProduct