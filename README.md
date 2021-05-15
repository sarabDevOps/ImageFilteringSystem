# Image Filtering System

![](https://github.com/sarabDevOps/ImageFilteringSystem/blob/main/filteringSystemImage.PNG)

#### The project is made for as a part of college work , Module  OOP

### Overview
A Java API that can apply one or more kernel filters to an image or a directory of images.

### Using Kernels to Filter Images

Images are typically stored on a computer in a compressed lossy (JPEG) or lossless (GIF, PNG) 
format. When an image is opened in a graphics application like Photoshop or GIMP, it is 
usually rasterized and converted into a bitmap that uses a 32 bit integer to represent a pixel. 
Each pixel therefore can encode the four ARGB (alpha, red, green, blue) channels using 1 byte, 
creating a range of [0...255] for each channel. The 24 bits of the 3 RGB channels can be used 
to represent 2563
=224=16,777,216 different colours, with the alpha channel controlling the 
transparency of the image. A raw bitmap image of dimensions 800 x 600 pixels will contain a 
total of 480,000 pixels.
Among the many features of a graphics application like Photoshop is the ability to filter an 
image to create some kind of an effect. These effects include edge detection, blurring, 
sharpening and embossing and are created by applying a matrix of values to each pixel in the 
image. The matrix of values is called a convolution matrix, a kernel, or a kernel matrix. A 
convolution is a mathematical operation that blends two functions together

![](https://github.com/sarabDevOps/ImageFilteringSystem/blob/main/Matrix.PNG)

The matrix itself is just a 2D array of numbers that slides across the pixels of the rasterized 
image and is used to compute a new value for each pixel. In the image in Fig. 2, the 3 x 3 kernel 
can be used to detect the edges in an image by changing the value of a pixel using the weights 
in the kernel and the immediate surrounding pixels in the image. In the example, the pixel value
89 is converted to 145 by the convolution. The same operation is applied to every pixel in the 
image, including edge pixels at the top, bottom and sides. If the image is in greyscale format,
all pixels are encoded with 1 byte and have a value in the range [0..255] and the convolution 
can be performed by tiling over the image as shown in Fig. 2. If the image is in RGB colour, 
the convolution needs to be applied separately to each colour channel.


### Getting Started

Download the zip archive , Navigate to the folder usind command promt this command will let you run the project :

java –cp ./oop.jar ie.gmit.sw.Runner.Runner


### Versioning

Version 1

### Authors

[SarabDevOps](https://github.com/sarabDevOps)


## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/sarabDevOps/ImageFilteringSystem/blob/main/LICENSE) file for details










