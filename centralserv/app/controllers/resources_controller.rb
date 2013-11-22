class ResourcesController < ApplicationController

  def index
    @resources = Resource.all
    @school = School.find(1)

    @requests = @school.requests.map {|request| request.resources}.flatten

  end

  def new
    @resource = Resource.new
  end

  def show
    @resource = Resource.find(params[:id])
  end

  def create
    @resource = Resource.create(resource_params)
    # @resource.image_url = Photo.all.sample.image_url unless @resource.image_url
    redirect_to resources_path, :notice => "Resource created successfully!"
  end

  private

  def resource_params
    params.require(:resource).permit(:name, :description, :image_url, :school_id)
  end

end
